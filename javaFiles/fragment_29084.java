for (int i = 0; i < COUNT * 2; i++) {

    b.acquire();

    System.out.print("B ");

    if (i % 2 == 1) {
        c.release();
    } else {
        b.release();
    }

    Thread.sleep(DELAY);
}