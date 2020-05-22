Queue<Item> items = new LinkedList<>();
PublishSubject<Item> subject = PublishSubject.create(); 

...
//subscribe once and supply new items in onClick
subject.subscribeOn(Schedulers.io())
    .flatMap(ItemUtils::doSomeHeavyProcessing)
    .observeOn(AndroidSchedulers.mainThread())
    .subscribe();

...
public void onClick() {
    while(!queue.isEmpty()){
        subject.onNext(queue.remove());
    }
}