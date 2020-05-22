List<A> listOfA = new ArrayList<A>();
Criteria criteria = session.createCriteria(B.class, "b");
criteria.add(Restrictions.eq("b.id", "B1"));
List<B> listOfBs = criteria.list();
for (B b : listOfBs) {
    listOfA.addAll(b.getA());
}