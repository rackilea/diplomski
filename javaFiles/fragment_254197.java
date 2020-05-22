//TreeMap to store the "ranges"
TreeMap<Integer, Double> theMap = new TreeMap<Integer, Double>();
//add the data
theMap.put(99, 0.3);
theMap.put(499, 0.28);
theMap.put(749, 0.27);
theMap.put(1000, 0.26);
//the "default" value for max entries
theMap.put(Integer.MAX_VALUE, 0.25);
//testing the solution
Double ex1 = theMap.ceilingEntry(50).getValue();
Double ex2 = theMap.ceilingEntry(500).getValue();
Double ex3 = theMap.ceilingEntry(5000).getValue();
Double ex4 = theMap.ceilingEntry(100).getValue();
System.out.println(ex1);
System.out.println(ex2);
System.out.println(ex3);
System.out.println(ex4);