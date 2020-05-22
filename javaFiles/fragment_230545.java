;; original prime? function
(defn prime? [n]
  (or (= n 2) 
      (not (some #(zero? (rem n %)) 
                 (conj (range 3 
                              (inc (Math/sqrt n)) 
                              2) 
                       2)))))

;; prime? function using recur
(defn prime?-recur [num]
  (cond (< num 2) false
        (= num 2) true
        (zero? (mod num 2)) false
        :else (loop [n num
                     i 3]
                (cond (>= i (inc (Math/sqrt n))) true
                      (zero? (mod n i)) false
                      (< i (inc (Math/sqrt n))) (recur n (+ i 2))))))

;; original printPrimes with option for testing both prime? funs
;; note I changed this to start on 2 since 1 is not prime
(defn printPrimes [n fn] (take n (filter fn (iterate inc 2))))

;; printPrimes using recursion
(defn printPrimes-recur [num fn]
  (loop [n num i 2 primes []]
    (cond (and (fn i) (< (count primes) n)) (recur n (+ i 1) (conj primes i))
          (< (count primes) n) (recur n (+ i 1) primes)
          :else primes)))