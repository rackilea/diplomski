final Object[] registrar = { null };
    int k = new HashSet<Integer>(){
        { registrar[0] = this; }
        int i= 666;
    }.i;
    Set<Integer> set = (Set<Integer>) registrar[0];

    System.out.println(k); // 666
    System.out.println(set.getClass().isAnonymousClass()); // true