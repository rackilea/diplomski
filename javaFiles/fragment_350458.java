startConn.setOnAction(e -> {
            Thread t1 = new Thread(new Runnable() {
                public void run()
                {
                    MultiThreadServer mts = new MultiThreadServer();

                    try {
                        mts.startServer();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }});  
                t1.start();