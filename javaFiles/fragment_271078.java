(defn do-task [] 
  (println (java.util.Date.) "doing task"))

(defn worker [f n wait]
            (doseq [task (repeat n f)]
                   (f)
                   (Thread/sleep wait)))

;; use future to execute worker in a background thread managed by Clojure
(future (worker do-task 10 1000))

;; the call to future returns immediately but in the background console
;; you will see the tasks being run.