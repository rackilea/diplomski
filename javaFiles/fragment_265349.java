Iterator<Integer> itr = countermap.keySet().iterator();
while (itr.hasNext()) {               _
    Integer next = itr.next();         |
    System.out.println(next);           }<---- HERE
    mod = next % 2;                   _|
    result = result + mod;
}