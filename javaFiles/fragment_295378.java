Map<Integer, YourClass> partitions = new TreeMap<Integer, YourClass>();
 for (YourClass x: set){
    Integer p = x.getA();
    if (partitions.containsKey(p))
       continue;
    partitions.put(p, x);
 }