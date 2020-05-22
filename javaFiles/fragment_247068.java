final Observable<Integer> allNumbers =
        Observable.from(new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10})
                .share();
Observable<Integer> oddNumbers = allNumbers.filter(new Func1<Integer, Boolean>() {
    @Override
    public Boolean call(Integer integer) {
        return integer % 2 != 0;
    }
});
Observable<Integer> evenNumbers = allNumbers.filter(new Func1<Integer, Boolean>() {
    @Override
    public Boolean call(Integer integer) {
        return integer % 2 == 0;
    }
});

final Action1<Integer> printingAction = new Action1<Integer>() {
    @Override
    public void call(Integer t) {
        System.out.println(Thread.currentThread() + " " + t);
    }
};

evenNumbers.subscribeOn(Schedulers.computation()).subscribe(printingAction);
oddNumbers.subscribeOn(AndroidSchedulers.mainThread()).subscribe(printingAction);