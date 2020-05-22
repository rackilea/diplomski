@Override
    public void start(Stage primaryStage) 
    {
        primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            public void handle(WindowEvent we) {
                System.out.println("Stage is closing");
                System.exit(0);
            }
        });  

        primaryStage.setTitle("Hello World!");
//      add your components
        primaryStage.show();
//      not daemon
        new Thread(new CustomRunnable()).start();

    }

    private static class CustomRunnable implements Runnable
    {
        public void run() 
        {

            while(true){
//              long operation
            }
        }
    }