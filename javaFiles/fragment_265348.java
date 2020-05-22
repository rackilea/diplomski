Iterator<Integer> itr = countermap.keySet().iterator(); <---- HERE
while (itr.hasNext()) {
    System.out.println(itr.next());
    mod = itr.next()% 2;
    result = result + mod;
}