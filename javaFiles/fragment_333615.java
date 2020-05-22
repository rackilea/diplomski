(import 'Test)

;; create all the objects
(def t1 (Test.))
(def t2 (Test.))
(def t3 (Test.))
(def t4 (Test.))
(def t5 (Test.))
(def t6 (Test.))

;; and lets chain them together:
(.add t1 (.add t2 (.add t3 (.add t4 (.add t5 t6)))))

;; verify using member access:
(= t6 (.. t1 a a a a a))  ;; true

;; verify using method call:
(= t6 (.. t1 getA getA getA getA getA)) ;; true

;; and mixed access
(= t6 (.. t1 a a getA a a))  ;; true

;; lets invoke foo:
(.. t1 getA getA getA getA getA (foo 1 2 3)) ;; 6

;; and invoke foovar:
(.. t1 getA getA getA getA getA (foovar (into-array[1 2 3]))) ;; 6