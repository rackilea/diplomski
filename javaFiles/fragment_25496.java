(ns subclass.core
  (:gen-class
   :extends Baseclass
   :exposes-methods {greet pgreet})
  (:import Baseclass))

;; You need to define a function for the overridden method
(defn greet- [this]
  (. this (pgreet)))

(defn greet []
  ;; You need to use the *gen-class*ed class, not BaseClass
  (. (new subclass.core) (greet))))