Random r = new Random();
    int[] ints = new int[500000];
    for (int i = 0 ; i < ints.length ; i++)
        ints[i] = r.nextInt();

    for (int i = 0 ; i < ints.length-1; i++)
        GCD(i,i+1);
    for (int i = 0 ; i < ints.length-1; i++)
        gcdThing(i, i + 1);

    long start = System.currentTimeMillis();
    for (int i = 0 ; i < ints.length-1; i++)
        GCD(i,i+1);
    System.out.println("GCD: " + (System.currentTimeMillis() - start));

    start = System.currentTimeMillis();
    for (int i = 0 ; i < ints.length-1; i++)
        gcdThing(i, i + 1);
    System.out.println("gcdThing: " + (System.currentTimeMillis() - start));