Criteria criteria = session.createCriteria(clazz);
 if (criterionList != null)
 {
   for(Criterion criterion : criterionList) 
     criteria.add(criterion);
 }

 // get the full list
 @SuppressWarnings("unchecked")
 List<T> objectList = criteria.list();