Criteria criteria = session.createCriteria(Phone.class, "phone"); 
  criteria.createAlias("phone.person", "person")
  criteria.add(Restrictions.between("phone.price", minPrice, maxPrice));
  criteria.createAlias("phone.manufacturer","manufacturer");
  criteria.add(Restrictions.eq("manufacturer.name", Samsung)); 
  criteria.setProjection(Projections.property("person"));

  List<Person> persons = criteria.list();