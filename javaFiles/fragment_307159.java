public class FooService {

    Observable<Foo> getFoo() {
        return Observable.fromCallable(new Callable<Foo>() {
            @Override
            public Foo call() throws Exception {
                return new Foo();
            }
        });
    }
}