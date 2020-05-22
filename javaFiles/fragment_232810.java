(defn next-key [key str-hash]
  (let [str1 (first str-hash)
        hash1 (second str-hash)
        k2 (bit-xor (bit-xor key hash1) str1)]
        (bit-or (bit-shift-right k2 23) (bit-shift-left k2 9))))

(defn calculateChecksum2 [url]
  (let [kk
    (reduce next-key 1690912
      (partition 2                ; (72 98) (111 106) (119 121) ...
        (map int                  ; 72 98 111 106 119 121
          (interleave url (cycle "bjytk3lfj%3jklDskj"))))) ; "HbojwyNt..."
  ]
  (str "8" (toHex8 (bit-shift-right kk 8)) (toHex8 (bit-and kk 255)))))

(prn (calculateChecksum2 "HowNowBrownCow"))