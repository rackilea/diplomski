new Thread(new Runnable() {
        public void run() {
            // lists are local to the runnable
            List<String> userCns = new ArrayList<String>();
            List<String> recipients = new ArrayList<String>();
           ///other codes
        }
    }).start();