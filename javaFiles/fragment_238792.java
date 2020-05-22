;;; in leiningen.hooks.clj_first.clj

(ns leiningen.hooks.clj-first
  (:require [leiningen.compile :as leinc]
            [leiningen.javac :as javac]))

(defn compile-clj-first-hook [compile-task project & args]
  (apply compile-task
         (dissoc project :java-source-path)
         args))
  (javac/javac project))

(add-hook #'leiningen.compile/compile compile-clj-first-hook)