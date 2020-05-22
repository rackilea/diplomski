;; direct method call (x 1 million)
user> (time (dorun (repeatedly 1E6 #(Integer/rotateRight 2 3))))
"Elapsed time: 441.326 msecs"
nil

;; method call inside function (x 1 million)
user> (time (dorun (repeatedly 1E6 #((fn [a b] (Integer/rotateRight a b)) 2 3))))
"Elapsed time: 451.749 msecs"
nil

;; method call in function using apply (x 1 million)
user> (time (dorun (repeatedly 1E6 #(apply (fn [a b] (Integer/rotateRight a b)) [2 3]))))
"Elapsed time: 609.556 msecs"
nil