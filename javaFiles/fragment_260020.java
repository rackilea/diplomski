Random rand = new Random(System.currentTimeMillis());
    while(tm.size() < 10) {
        float price = Math.abs(rand.nextInt())%100;
        int capacity = Math.abs(rand.nextInt())%10;
        Udisk u = new Udisk(price, capacity);
        tm.put(u.price, u);
    }