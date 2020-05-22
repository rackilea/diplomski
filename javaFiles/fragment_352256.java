public void calculateData() {

    new Thread(new Runnable() {
        public void run() {
            try {
                System.out.println("calculating data...");
                // doing some calculate here
                Thread.sleep(3000);
                System.out.println("done calculting");
                // System.exit(0);
                int res = 1;
                if (res == 1) {
                    System.out.print("login ok");
                    showPanel2();
                } else {
                    System.out.print("login failed");
                    showPanel1();
                }
            } catch (Exception ex) {
                Logger.getLogger(CardPanel.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }).start();

}