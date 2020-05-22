public void refresh_check() {
        Thread myThread = new Thread()
        {
            int counter = 0;
            @Override
            public void run() {
                while (counter < 60) {
                            try {
                                Thread.sleep(1000);
                                counter += 1;
                                System.out.println("Counter: " + counter); //I think this may cause exception, if it does try removing it
                            } catch (InterruptedException e) { 
                                // TODO Auto-generated catch block
                                e.printStackTrace();
                            }
                        }
                        refresh(); // In refresh(), use TextView.post(runnable) to post update the TextView from outside the UI thread or use handlers
                    }});
                super.run();
            };
        myThread.start();       
    }