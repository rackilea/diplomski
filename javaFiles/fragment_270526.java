int val = 100;
Observable res = Observable.empty();
while(val >= 0) {
    res = Observable.concat(
            res,
            service.postSomething([...], val),
            Observable.timer(5, TimeUnit.SECONDS)
    );
    val -= 10;
}
res.subscribe(); //completion handler will be invoked when done