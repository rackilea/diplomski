(import (javax.servlet Servlet ServletRequest ServletResponse))

(defprotocol PFoo
  (foo [this x y z]))

(reify
  Servlet
  (service [this ^ServletRequest req ^ServletResponse res]
    ...)
  ;; other Servlet methods here...
  PFoo
  (foo [this x y z]
    ...))