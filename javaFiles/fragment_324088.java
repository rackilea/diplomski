ExecutorService service =  Executors.newFixedThreadPool(10);           

for(int i=0; i<5;i++){
  Future future=  service.submit(new MessengerClient("Thread "+i+" :"));
  }        

service.shutdown();