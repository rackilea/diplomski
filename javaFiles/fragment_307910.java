Completable.concat(
    completableTwoSeconds(), 
    Completable.defer(() -> completableTwoSeconds())
)
.doOnCompleted(() -> System.out.println("Both completed."))
.await();