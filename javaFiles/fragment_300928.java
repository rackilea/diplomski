List<Observable<?>> list = Arrays.asList(Observable.just(1), Observable.just("2"));
Observable.combineLatest(list, new FuncN<String>() {
    @Override
    public String call(Object... args) {
        String concat = "";
        for (Object value : args) {
            if (value instanceof Integer) {
                concat += (Integer) value;
            } else if (value instanceof String) {
                concat += (String) value;
            }
        }
        return concat;
    }
});