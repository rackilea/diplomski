public class FooBarService {

    private final FooService fooService;
    private final BarService barService;

    public FooBarService(FooService fooService, BarService barService) {
        this.fooService = fooService;
        this.barService = barService;
    }

    Observable<Bar> getFooBar() {
        return fooService.getFoo()
                .concatMap(new Function<Foo, ObservableSource<? extends Bar>>() {
                    @Override
                    public ObservableSource<? extends Bar> apply(@NonNull Foo foo) throws Exception {
                        return barService.getBar(foo);
                    }
                });
    }
}