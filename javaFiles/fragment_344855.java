class MyList<T> {
    final PublishSubject<T> onAdded = PublishSubject.create();
    void add(T value) {
        // add internally
        onAdded.onNext(value);
    }
    Observable<T> onAdded() {
        return onAdded;
    }
}

MyList<Integer> list = populate();

Subscription s = list.onAdded()
    .subscribe(v -> System.out.println("Added: " + v));

list.add(1);  // prints "Added: 1"
list.add(2);  // prints "Added: 2"
list.add(3);  // prints "Added: 3"

s.unsubscribe(); // not interested anymore

list.add(4);  // doesn't print anything
list.add(5);  // doesn't print anything