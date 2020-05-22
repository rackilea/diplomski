;; 1. Refactored `java-get-package' into its own `defun'
;; 2. Refactored `java-package-directory' into its own `defun'
;; 3. Broke out `defun's outside of `java-mode-hook'
;; 4. Use (let ((default-directory ...) ...) instead of (cd ...) (...)
;; 5. Broke out keystroke assignments into `my-java-mode-hook'

(defun java-get-package ()
  "Get package definition before point"
  (interactive)
  (save-excursion
    (save-match-data  ;; Added; you want this too
      (goto-char (point-min))
      (when (re-search-forward "^\\s *package\\s +\\(.*\\);"
                               (point-max) t)
        (match-string 1)) )) )

(defun java-package-directory (package)
  "Get package directory of PACKAGE in current buffer"
  (let ((directory (file-name-directory (buffer-file-name)))
        sub-dirs)
    (if directory
        (setq directory (file-truename directory))
      (error "Current buffer is not visiting a file"))
    (save-match-data
      (setq sub-dirs (reverse (split-string package "\\.")))
      (while sub-dirs
        (if (string-match (concat "^\\(.*/\\)"
                                  (regexp-quote (car sub-dirs)) "/$")
                          directory)
            (setq directory (match-string 1 directory)
                  sub-dirs (cdr sub-dirs))
          (error "Package does not match directory structure") ) ) )
    directory) )

(defun java-compile-current-file ()
 "Compiles the current file with javac"
 (interactive)
 (let* ((package (java-get-package))
        (default-directory (java-package-directory package)) )
   (compile
    (concat "javac -Xlint:all " ; Removed too noisy -Werror
        (if package (concat package "/") "")
        (file-name-nondirectory (buffer-file-name)) ) ) ))

(defun java-run-current-file ()
 "Runs the java program the current file corresponds to"
 (interactive)
 (let* ((package (java-get-package))
        (default-directory (java-package-directory package)) )
   (shell-command
    (concat "java "
        (if package (concat package ".") "")
        (file-name-sans-extension
         (file-name-nondirectory (buffer-file-name)) ) )) ))

(defun my-java-mode-hook () "Stuff to run when entering Java mode"
    (local-set-key [(f7)] 'java-run-current-file)
    (local-set-key [(f8)] 'java-compile-current-file) )

(add-hook 'java-mode-hook #'my-java-mode-hook)