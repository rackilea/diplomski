long timestamp = -10;

    for (int i = 0; i < 20; i++) {

        System.out.println("timestamp = " + timestamp + " date = " + (new Date(timestamp)));
        timestamp*=10;
    }