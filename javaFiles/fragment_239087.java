new Thread() {
    public void run() {
        try {
            while (true){
                if (sum.contains(jLabel11.getText())) {
                    System.out.println("Now equal");
                    break;
                }
            }
        } catch (InterruptedException ex) {
            Logger.getLogger(AlarmClock.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}.start();