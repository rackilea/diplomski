(ns erikcw)

(defn toHex8 [n] (format "%08x" n))        ; Just a guess!

                                           ; can't use str, that's predefined.
(defn calculateChecksum [url]               ; I renamed the arg to url so I can use strn later.
  (loop [strn url                          ; this will loop over chars in strn.
         hash (cycle "bjytk3lfj%3jklDskj") ; now hash repeats for as long as you need it.
         key 1690912]                      ; modifying key along the way.
    (prn strn key)                           ; debug print.
    (let [k2 (bit-xor (bit-xor key (int (first hash))) (int (first strn)))
          k3 (bit-or (bit-shift-right k2 23) (bit-shift-left k2 9))]
      (if (empty? (rest strn))
        (str "8" (toHex8 (bit-shift-right k3 8)) (toHex8 (bit-and k3 255)))
        (recur (rest strn) (rest hash) k3)))))

(prn (calculateChecksum "HowNowBrownCow"))