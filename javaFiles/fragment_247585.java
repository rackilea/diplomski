tx.begin();
Comment c = new Comment();
Attribute a = new Attribute();
em.persist(a);
c.setAttributes(new HashSet<>());
c.getAttributes().add(a);
em.persist(c);
tx.commit();

// to remove everything from cache
em.clear();

// this does nothing except a select since the attribute is already in the set of attributes
// and in fact the `em.find` does not issue a select in this case because
// the attribute gets loaded into the cache from the Comment select.
tx.begin();
Comment c2 = em.createQuery("select c from Comment c left join fetch c.attributes where c.id = 2", Comment.class).getSingleResult();
Attribute a2 = em.find(Attribute.class, 1);
c2.getAttributes().add(a2);
tx.commit();