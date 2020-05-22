final Observable<Integer> allNumbers =
        Observable.from(new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10})
                .share();
Observable<Integer> oddNumbers = allNumbers.filter(integer -> integer % 2 != 0);
Observable<Integer> evenNumbers = allNumbers.filter(integer -> integer % 2 == 0);

final Action1<Integer> printingAction = 
         t -> System.out.println(Thread.currentThread() + " " + t);

evenNumbers.subscribeOn(Schedulers.computation()).subscribe(printingAction);
oddNumbers.subscribeOn(AndroidSchedulers.mainThread()).subscribe(printingAction);