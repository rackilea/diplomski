Object[] tuple = new HashSet<Integer>(){
        Object[] tuple = { this, 666, 13, "XXX", "OMG ABUZE" };
    }.tuple;
    Set<Integer> set = (Set<Integer>) tuple[0];
    set.add(null);
    System.out.println(set.getClass().isAnonymousClass()); // true
    System.out.println(Arrays.toString(tuple));
    // [[null], 666, 13, XXX, OMG ABUZE]