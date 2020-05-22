Thread myThread = new Thread();

        try {
            myThread.join();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        myThread = null;