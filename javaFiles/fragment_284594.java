Scanner scan = new Scanner(System.in);
    Timer timer = new Timer();
    timer.schedule(new TimerTask() {

        @Override
        public void run() {
            //Do whatever you want with your messages here
        }
    }, 0, 1000);

    //Wait for user input
    while(true) {
        String bar = scan.next();
    }