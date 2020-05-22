Timer obRunTime = new Timer();
        obRunTime.schedule(new TimerTask() {

        @Override
        public void run() {
            // TODO Auto-generated method stub
            System.out.println("will be printed after 5 seconds");
        }
    },5000);