SQLQuery q = session.createSQLQuery("SELECT * FROM Neighborhood");        
    q.addScalar("neighborhoodName");    
    q.addScalar("educationYouth");   
     List<Object[]> rows = q.list();
for (Object[] row : rows) {
    System.out.println(row[0] + " " + row[1] );