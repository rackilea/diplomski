AtomicInteger i = new AtomicInteger(0);
Flowable
    .fromIterable(itemList)
    .parallel()
    .runOn(Schedulers.io())
    .map(item -> {
        Thread.sleep(1000); //imitate expensive computation
        return item.getCode();
     })
     .sequential()
     .observeOn(JavaFxScheduler.platform())
     .subscribe(result -> {
         i.increment();
         progressBar.setProgress((float)(i.get()/itemList.size))
         System.out.println(result);
      });