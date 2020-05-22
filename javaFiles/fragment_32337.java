426         if (cache) {
427             Principal principal = request.getUserPrincipal();
428             if (principal == null) {
429                 Session session = request.getSessionInternal(false);
430                 if (session != null) {
431                     principal = session.getPrincipal();
432                     if (principal != null) {
433                         if (log.isDebugEnabled()) {
434                             log.debug("We have cached auth type " +
435                                 session.getAuthType() +
436                                 " for principal " +
437                                 session.getPrincipal());
438                         }
439                         request.setAuthType(session.getAuthType());
440                         request.setUserPrincipal(principal);
441                     }
442                 }
443             }
444         }