(defun java-run-current-file ()
  "Runs the java program the current file corresponds to"
  (interactive)
  (let* ((package (save-excursion
                    (goto-char (point-min))
                    (when (re-search-forward "^\\s *package\\s +\\(.*\\);" (point-max) t)
                      (match-string 1))))
         (directory (file-name-directory (buffer-file-name)))
         sub-dirs)

    (if directory
        (setq directory (file-truename directory))
      (error "Current buffer is not visiting a file"))

    (when package
      (setq sub-dirs (reverse (split-string package "\\.")))

      (while sub-dirs
        (if (string-match (concat "^\\(.*/\\)" (regexp-quote (car sub-dirs)) "/$") directory)
            (setq directory (match-string 1 directory)
                  sub-dirs (cdr sub-dirs))
          (error "Package does not match directory structure"))))

    (cd directory)
    (shell-command
     (concat "java "
             (if package (concat package ".") "")
             (file-name-sans-extension
              (file-name-nondirectory (buffer-file-name)))))))