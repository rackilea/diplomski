class HeartBeatTask extends TimerTask {

        private int timerInterval;

        public HeartBeatTask(int timeInterval)
        {
            this.timerInterval = timeInterval;
        }

        public void run() 
        {
            String fullIstring = java.lang.String.valueOf(injectString[0] + injectString[1] + injectString[2] + injectString[3] + injectString[4]);
                        jLabel3.setText(fullIstring);
                        System.out.println("output");

        }

      }