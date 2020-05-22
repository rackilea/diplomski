Criteria criteria = session.createCriteria(YourEntity.class);
if(clause){
   criteria.addOrder( Order.asc("property_desired_1") );
}else{
  criteria.addOrder( Order.asc("property_desired_2") );
} 
criteria.list();