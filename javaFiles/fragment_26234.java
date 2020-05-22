List<Parent> po1 = em.createQuery("select p from Parent p join p.children c where c.key='c1' order by c.property asc", Parent.class).getResultList();
System.out.println(po1);

CriteriaBuilder cb = em.getCriteriaBuilder();
CriteriaQuery<Parent> cq = cb.createQuery(Parent.class);
Root<Parent> p = cq.from(Parent.class);
Join<Parent, Child> c = p.join("children");
cq.select(p).where(cb.equal(c.get("key"), "c1")).orderBy(cb.asc(c.get("property")));
List<Parent> po3 = em.createQuery(cq).getResultList();
System.out.println(po3);