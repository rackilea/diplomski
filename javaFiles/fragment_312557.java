List<?> objList = session.createQuery("SELECT new map(c.EMP_ID as empId, 
                  COUNT(*) as empCount) FROM employee c WHERE c.CITY=:someCity").list();
Iterator<?> myRows = objList.iterator();    
while (myRows.hasNext()) {
    Map row = (Map) myRows.next();
    System.out.println(row);
}