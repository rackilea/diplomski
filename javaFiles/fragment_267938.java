BigInteger bi = BigInteger.ZERO; 

    Random rand = new Random();

    while (true) {
        bi = bi.add(BigInteger.ONE);

        boolean x = rand.nextBoolean();
        if (x == rand.nextBoolean()
            && x == rand.nextBoolean()
            && x == rand.nextBoolean()
            && x == rand.nextBoolean()
            && x == rand.nextBoolean()
            ...
            ) {

            System.out.println(bi);
            System.out.print(x);
            return;
        }
    }