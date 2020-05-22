Criteria criteria = session.createCriteria(MyClass.class);
Disjunction sizeDisjunction = Restrictions.disjunction();

String[] sizes = { "small", "medium", "large" };
for(int i = 0; i < sizes.length; i++){
   sizeDisjunction.add(Restrictions.eq("size", sizes[i]);
}
criteria.add(sizeDisjunction );