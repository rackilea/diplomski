interface IFutureListener{
    void onException( Throwable t );
}


final IFutureListener errHandler = new IFutureListener(){
     @override public void onException( Throwable t ){
          // shutdown Service here
     }
};
// ...
Future<?> handle = scheduler.scheduleWithFixedDelay(new Runnable() {
        final IFutureListener callback = errHandler;
        public void run() {
            try{
            System.out.println("No exception!");
            if (i > 2) {
                System.out.println("Exception!");
                throw new RuntimeException("foo");
            }
            i++;
            }
            catch( Exception ex ){
                callback.onException(ex);
            }
        }
    }, 0, 500, TimeUnit.MILLISECONDS);