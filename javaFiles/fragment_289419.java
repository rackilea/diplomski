class RxStreamAdapter implements CallAdapter {

    private final Class rawType;
    private final CallAdapter<Object, Object> nextAdapter;
    private final Type returnType;

    RxStreamAdapter(Class rawType,
                    Type returnType,
                    CallAdapter nextAdapter) {
        this.rawType = rawType;
        this.returnType = returnType;
        this.nextAdapter = nextAdapter;
    }

    @Override
    public Type responseType() {
        return nextAdapter.responseType();
    }

    @Override
    public Object adapt(Call call) {
        if (rawType == Single.class) {
            return ((Single) nextAdapter.adapt(call))
                    .doOnSubscribe(getDoOnSubscribe())
                    .doFinally(getDoFinally());
        } else if (returnType == Completable.class) {
            return ((Completable) nextAdapter.adapt(call))
                    .doOnSubscribe(getDoOnSubscribe())
                    .doFinally(getDoFinally());
        } else {
            // Observable
            return ((Observable<Object>) nextAdapter.adapt(call))
                    .doOnSubscribe(getDoOnSubscribe())
                    .doFinally(getDoFinally());
        }
    }

    @NotNull
    private Consumer<Disposable> getDoOnSubscribe() {
        return disposable -> {

        };
    }

    @NotNull
    private Action getDoFinally() {
        return () -> {

        };
    }
}