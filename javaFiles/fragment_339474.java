int h = 0;
    int t = 0;
    for (int i = 0; i < 1000; i++) {
        int num = (int) (1000 * Math.random());
        if (num < 500) {
            h++;

        } else {
            t++;

        }
    }
    System.out.println("T:" + t);
    System.out.println("H:" + h);