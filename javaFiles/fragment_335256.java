while(true) {
        // don't forget to make num final!
        final int num = 25 + (int)(Math.random() * ((40 - 30) + 1));
        System.out.println(num);
        SwingUtilities.invokeLater(new Runnable(){
          public void run() {
            ts.addOrUpdate(new Millisecond(), num);                
          }
        });
        // ts.addOrUpdate(new Millisecond(), num);
        System.out.println("HI");
        try {
            Thread.sleep(20);
        }
        catch (InterruptedException ex) {
            System.out.println(ex);
        }
    }