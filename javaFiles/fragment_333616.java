;; get the object at depth n using functions
(defn get-nth-function [o n]
  (first (drop n (iterate (memfn getA) o))))

;; get the object at depth n using member access.
;; This same notation could also be used for function,
;; however I just wanted to show an example of memfn
(defn get-nth-member [o n]
  (first (drop n (iterate #(.a %) o))))

;; lets verify:
(= t6 (get-nth-member t1 5)) ;; true

;; lets invoke foovar on object position 6, 
;; on a range of numbers from 1 to 10
(.foovar (get-nth t1 5) (into-array (range 10))) ;; 45