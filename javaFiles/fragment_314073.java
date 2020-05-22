//Create a query that is checking columns on FooTable.
Criteria criteria = session.createCriteria(FooTable.class); 
//FooTable is where stime is stored. 

//Create a restriction on your query to only return records where the 'stime'
//column is less than the current system time.
criteria.add(Restrictions.lt("stime", new Time(System.currentTimeMillis()));

 //return all records in a list format.
 List list = criteria.list();
 //iterate over your list here.