class ResultHolder<T, E extends Exception> {
    private T result;
    private E exception;

    public ResultHolder(T result) {
        this.result = result;
    }
    public ResultHolder(E exception) {
        if (exception == null) {
            throw new IllegalArgumentException("exception can not be null");
        }
        this.exception = exception;
    }

    public T get() throws E {
        if (exception != null) {
            throw exception;
        } else {
            return result;
        }
    }

    public Observable<T> observe() {
        if (exception != null) {
            return Observable.error(exception);
        } else {
            return Observable.just(result);
        }
    }

    @SuppressWarnings("unchecked")
    public static <T, E extends Exception> ResultHolder<T, E> wrap(BusinessMethod<T, E> method) {
        try {
            return new ResultHolder<>(method.call());
        } catch (Exception e) {
            return new ResultHolder<>((E)e);
        }
    }


    public static <T, E extends Exception> Observable<T> unwrap(ResultHolder<T, E> holder) {
        return holder.observe();
    }

    interface BusinessMethod<T, E extends Exception> {
        T call() throws E;
    }
}