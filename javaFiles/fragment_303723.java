Person p1 = new Person();
Person p2 = new Person();
Relationship r = new Relationship();

// create the personFrom bi-directional association
r.setPersonFrom(p1);
List<Relationship> relationships = new ArrayList<Relationship>();
relationships.add(r);
p1.setRelationships(relationships); // these four lines should be moved to some 
                                    // link management method (see update below).

// create the personTo uni-directional association
r.setPersonTo(p2);

session.persist(p2);
session.persist(p1);

assertNotNull(p2.getId());
assertNotNull(p1.getId());
assertNotNull(r.getId());