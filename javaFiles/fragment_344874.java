Integer indexValue = (Integer)

session.createQuery("select count(*) from Property p where p.propertyId.rederenceId = :referenceId and p.propertyId.propertyId = :propertyId")
       .setParameter("referenceId", referenceId)
       .setParameter("propertyId", propertyId)
       .iterate()
       .next();