(ns decode-jwt
  (:require [cheshire.core :as json])
  (:import [org.apache.commons.codec.binary Base64]))

(-> returned-jwt ;; returned-jwt is your full jwt string
    (clojure.string/split #"\.") ;; split into the 3 parts of a jwt, header, body, signature
    second ;; get the body
    Base64/decodeBase64 ;; read it into a byte array
    String. ;; byte array to string
    json/decode ;; make it into a sensible clojure map
    )