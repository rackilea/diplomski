public class BarService {

    Observable<Bar> getBar(final Foo foo) {
        return Observable.fromCallable(new Callable<Bar>() {
            @Override
            public Bar call() throws Exception {
                return new Bar(foo);
            }
        });
    }
}