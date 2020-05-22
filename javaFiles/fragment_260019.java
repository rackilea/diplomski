Random rand = new Random(System.currentTimeMillis());
    for(int count=0; count < 10; count++) {
        float price = Math.abs(rand.nextInt())%100;
        int capacity = Math.abs(rand.nextInt())%10;
        Udisk u = new Udisk(price, capacity);
        tm.put(u.price, u);
    }