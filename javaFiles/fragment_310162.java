Flowable<Integer> rxRoomSourceFlowable = 
    Flowable.fromArray(1, 2, 3)
    .subscribeOn(Schedulers.io())
    .share();

rxRoomSourceFlowable
.observeOn(Schedulers.io())
.map(integer -> {
    // Some long running operation
    Thread.sleep(5000);
    return integer + "!";
})
.subscribe(str -> System.out.println("Mapped subscriber: " + str));

rxRoomSourceFlowable
.subscribe(integer -> System.out.println("Plain subscriber: " + integer));