StringBuilder queryBuilder = new StringBuilder();
queryBuilder.append("select * from table1 ");

if ( child1 != null && child2 == null) 
   queryBuilder.append(" where child1 = 1 ");
else if ( child2 != null && child1 == null)
   queryBuilder.append(" where child2 = 1 ");
else
   queryBuilder.append(" where bla ");

// Execute queryBuilder.toString();
rset = stmt.executeQuery(queryBuilder.toString());