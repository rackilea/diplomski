Random r = new Random(); 
    int heads = 0;
    for (int i = 0; i < 1000; i++) { 
        int side = random.nextInt(2);
        if (side == 1) {
            heads++;
        } 
    } 
    System.out.println("Times head was flipped:" + heads); 
    System.out.println("Times tail was flipped:" + (1000 - heads));