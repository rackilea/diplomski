String test = null;
    String test2 = "Hello";
    String test3 = "ASMDAKLSMDKLÖASDJAKLHRFÖKLASJDKLASMDKLASJDMASKLDMASKLÖDMASKLDMASKLÖMDKLÖASMDKASMDKL";

    {
        int u = 1;
        int v = 1;
        long max = 999999999l;
        long time;
        time = System.currentTimeMillis();
        for(int i = 0; i < max; i++) {
            if(test == null) u = v;
        }
        System.out.println("Test 1: " + (System.currentTimeMillis() - time) + " ms.");
    }

    {
        int u = 1;
        int v = 1;
        long max = 999999999l;
        long time;
        time = System.currentTimeMillis();
        for(int i = 0; i < max; i++) {
            if(test2 == null) u = v;
        }
        System.out.println("Test 2: " + (System.currentTimeMillis() - time) + " ms.");
    }

    {
        int u = 1;
        int v = 1;
        long max = 999999999l;
        long time;
        time = System.currentTimeMillis();
        for(int i = 0; i < max; i++) {
            if(test3 == null) u = v;
        }
        System.out.println("Test 3: " + (System.currentTimeMillis() - time) + " ms.");
    }

    {
        int u = 1;
        int v = 1;
        long max = 999999999l;
        long time;
        time = System.currentTimeMillis();
        for(int i = 0; i < max; i++) {
        }
        System.out.println("Test 3: " + (System.currentTimeMillis() - time) + " ms.");
    }