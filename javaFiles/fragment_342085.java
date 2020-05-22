try {
            Thread.sleep(1000);
            System.out.println("I did the Thread");
        } catch (InterruptedException e) {
            this.interrupt();
           // No need for break
        }