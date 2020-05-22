SingleSubject<RedType> red = SingleSubject.create();
SingleSubject<BlueType> blue = SingleSubject.create();

// subscribe interested parties
red.subscribe(...);
blue.subscribe(...);

Single.zip(red, blue, (r, b) -> ...).subscribe(...);

// connect()
blueObservable.subscribe(blue);
redObservable.subscribe(red);