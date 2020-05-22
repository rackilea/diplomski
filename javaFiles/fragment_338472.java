final ITickHandler handler = new TickHandler();
PriceSource prices = new PriceSource(handler);

handler.priceReceivedObservable()
       .subscribe(new Subscriber<Tick>() {
          @Override public void onCompleted() { }
          @Override public void onError(Throwable e) { }
          @Override public void onNext(Tick tick) {
              System.out.println("Received price: " + tick.price);
          }});