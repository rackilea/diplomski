final FutureTask<Beef> killCows = new FutureTask<Beef>(
            new Callable<Beef>() {

                @Override
                public Beef call() throws Exception {
                    return new Beef();
                }
            });

    new Thread(new Runnable() {

        @Override
        public void run() {

            Beef beef = killCows.get();
            // prepare sirloin

        }
    }).start();

    new Thread(new Runnable() {

        @Override
        public void run() {

            Beef beef = killCows.get();
            // prepare rib

        }
    }).start();