(let [testfile "zerofile"]    ; $ dd if=/dev/zero of=zerofile bs=1k count=1k
  (map (fn [func label]
         (println label)
         (dotimes [_ 3]
           (time (with-open [data (func testfile)]
                   (while (not= -1 (.read data)))))))
    [clojure.java.io/input-stream,  clojure.java.io/reader]
    ["Input Stream:" "\nReader:"]))