booksObserve
   .map(Book::getAllOrders)
   .flatMap(Observable::fromIterable)
   .buffer(10)
   // ...some more steps here...
   .toList()
   .toObservable()
   // resubmit
   .doOnComplete(this::executeObserve)
   .subscribeOn(Schedulers.io())
   .subscribe(validISBN -> {
         // do something with the valid ones
    });