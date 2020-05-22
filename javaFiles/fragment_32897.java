Object[] array = new Object[6];

    long start = System.nanoTime();

    for(int i = 0; i < Integer.MAX_VALUE; i++){
        array[0] = null;
        array[1] = null;
        array[2] = null;
        array[3] = null;
        array[4] = null;
        array[5] = null;
    }
    System.out.println("elapsed nanoseconds: " + (System.nanoTime() - start));
    int length = array.length;

    start = System.nanoTime();
    for(int i = 0; i < Integer.MAX_VALUE; i++){
        array = new Object[6];
    }
    System.out.println("elapsed nanoseconds: " + (System.nanoTime() - start));
    length = array.length;