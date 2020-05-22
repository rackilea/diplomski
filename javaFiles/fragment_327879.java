public class UtilsObservable<T> {

    public static <T> Observable<T> setupObservable(Observable<T> observable) {
        return observable.observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.computation());
}