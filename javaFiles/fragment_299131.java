List<DTOPerson> names = query.from(p)
  .where(p.lastname.like("%smith%"))
  .orderBy(p.lastname.asc(), p.firstname.asc())
  .list(Projections.bean(DTOPerson.class, 
      p.lastname.trim().as("lastname"), 
      p.firstname.trim().as("firstname")));