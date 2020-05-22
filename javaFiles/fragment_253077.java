const a = Observable.interval(5000);
const b = Observable.interval(1000);

const sharedA = a.shareReplay(1);

const result = b.takeUntil(sharedA).concat(sharedA);