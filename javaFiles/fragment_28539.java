BehaviorSubject subject = new BehaviorSubject();
hotObservable.subscribe(subject);
subject.subscribe(thing -> {
    // Here just after subscribing 
    // you will receive the last emitted item, if there was any.
    // You can also always supply the first item to the behavior subject
});