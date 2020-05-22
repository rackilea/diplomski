@PostConstruct
    private void init(){
        addShutdownHook(); 
    }

 private void addShutdownHook(){
   Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {

            @Override
            public void run() {
                shutdown();
            }
        }));
    }