(defmacro set-fields 
  [options obj]
  (let [o (gensym)
        m (gensym)]
    `(let [~m ~options
           ~o ~obj]
       ~@(map (fn [[field value]]
                (let [setter (symbol (str "set" (clojure.string/capitalize (name field))))]
                  `(. ~o (~setter ~value))))
               options)
       ~o)))

;; call like:
(set-fields {:daemon true :name "my-thread"} (Thread.))

;; translates to:
;; (let [G__1275 {:daemon true, :name "my-thread"} 
;;       G__1274 (Thread.)]
;;   (. G__1274 (setDaemon true))
;;   (. G__1274 (setName "my-thread"))
;;   G__1274)