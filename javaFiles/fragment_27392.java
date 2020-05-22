Thread thread3 = new Thread(new Runnable(){
            public void run(){
                result3 = doSomething3();
            }
        });
thread3.start();
thread3.join();