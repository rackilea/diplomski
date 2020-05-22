Timer t = new Timer();
t.schedule(new TimerTask() {

            @Override
            public void run() {
                System.out.println("Hi!");

            }
        }, 400);