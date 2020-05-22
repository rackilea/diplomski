Long longValue = 20L; 
List<Long> longList = new ArrayList();
longList.add(longValue);

Integer i =10;
List<? extends Number> sNumber = longList ;// longList can be assigned to ? extends Number
sNumber.add(i); // if this was allowed
longValue = longList.get(1);   // we will get an exception (class cast exception)