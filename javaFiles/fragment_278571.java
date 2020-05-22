new Thread(new Runnable() {
            @Override
            public void run() {
                long time = System.currentTimeMillis();
                while (System.currentTimeMillis() < time + 1000){}
                Gdx.app.postRunnable(new Runnable() {
                    @Override
                    public void run() {
                        foo();
                    }
                });
            }
        }).start();