cancelEvents = BehaviourSubject.create();

// ...

subject
    .takeUntil(cancelEvents)
    .subscribe(...)

// ...

cancelEvents.onNext(someEvent);