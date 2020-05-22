System.out.println("Before creating tunnel...");
    final MyTunnel tunnel = new MyTunnel();
    System.out.println("After creating tunnel...");

    for (int i = 0; i < 100; ++i) {
        System.out.print("");
    }

    System.out.println("Is tunnel alive ? " + tunnel.isAlive()); // returns false on my machine