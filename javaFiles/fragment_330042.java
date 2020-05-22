List<Object[]> criteriaList = criteria.list();
List<Integer> monthList = Collections.emptyList();

for (Object[] row : criteriaList) {
    try{
        BigDecimal month = row[0];
        monthList.add(month.intValueExact());
    catch(Exception e){
        //To deal with casting Exception, NPE and 
        //ArithmeticException if int conversion fails
    }

    //Do what you want ...
}