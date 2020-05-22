//get session object from entity manager
Session session = em.unwrap(Session.

MultiIdentifierLoadAccess<A> multiLoadAccess = session.byMultipleIds(A.class);
List<A> aObjects= multiLoadAccess.withBatchSize(1000).multiLoad(idList);
return aObjects;