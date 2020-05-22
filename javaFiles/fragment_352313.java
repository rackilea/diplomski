public static void test(final int x, int y) {

        Thread thread = new Thread() {
            @Override
            public void run() {
                System.out.println(x);
            }
        };
        thread.start();

    }