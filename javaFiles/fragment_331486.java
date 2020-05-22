(defmacro obj-to-map 
  [obj & body]
  (let [afn (fn [[method kw]]
              `(~kw (. ~obj ~method)))]
  `(assoc {} ~@(mapcat afn (partition 2 body)))))

(obj-to-map "hello" length :length toString :value)  

=>  {:value "hello", :length 5}