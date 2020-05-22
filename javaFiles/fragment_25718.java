public void startUP(final ClientGUI cg){
       new java.util.Timer().schedule( 
        new java.util.TimerTask() {
            @Override
            public void run() 
            {
                 System.out.println("sent");
                 cg.output();
            }
        }, 
        5000 
);