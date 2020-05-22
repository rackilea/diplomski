String queryStr =
    "select NEW package.YourDefinedCustomClass(
     a.field1, b.field2, c.field3, c.field4) from a left outer join b 
     on a.id=b.fk left outer join c on b.id=c.fk";

TypedQuery<YourDefinedCustomClass> query =
    em.createQuery(queryStr, YourDefinedCustomClass.class);

List<YourDefinedCustomClass> results = query.getResultList();