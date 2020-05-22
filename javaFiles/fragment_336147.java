private int counter = 0;
private int total = 30; // the total number
//...
//when you want to start the counting start the thread bellow.
    new Thread(new Runnable() {

                public void run() {
                    while (counter < total) {
                        try {
                            Thread.sleep(500);
                        } catch (InterruptedException e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        }
                        t.post(new Runnable() {

                            public void run() {
                                t.setText("" + counter);

                            }

                        });
                        counter++;
                    }

                }

            }).start();