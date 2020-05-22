private class TickHandler implements ITickHandler {
   private final Tick tick;
   private final PublishSubject<Tick> priceSubject;

  TickHandler() { 
       this.tick = new Tick(); 
       this.priceSubject = PublishSubject.create();
   }

   @Override public void priceReceived(double x)
   { 
        tick.price = x; 
        priceSubject.onNext(tick);
   }

   public Observable<Tick> priceReceivedObservable()
   {
       return priceSubject.asObservable();   
   }
}