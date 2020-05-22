if (i > 100000) {
    i = 0;
    long took = System.currentTimeMillis() - time;
    time = System.currentTimeMillis();
    System.out.println("100000 bytes took " + took + " milliseconds which means " + (100000000 / took) + " bytes per second");
}