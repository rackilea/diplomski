java.util.TimerTask task = new java.util.TimerTask() {
        int prevCount = 0; // you can declare it static
        @Override
        public void run() {
            Connection conn = getConnection();
            try {
                ResultSet rs = conn.prepareStatement("Select Count(*) from table").executeQuery();
                int count = rs.getInt(1);
                System.out.println("Count diff:"+ (prevCount-count));
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    };
    java.util.Timer timer = new java.util.Timer(true);// true to run timer as daemon thread
    timer.schedule(task, 0, 5000);// Run task every 5 second
    try {
        Thread.sleep(60000); // Cancel task after 1 minute.
    } catch (InterruptedException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
    timer.cancel();