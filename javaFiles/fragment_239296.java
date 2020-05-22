List<Observable<MyResponse>> observables = new ArrayList<>();
List<String> values = getValues();
for (String value : values) {
    observables.add(myAPI.myMethod());
}
Observable.zip(observables, new FuncN() {
        @Override
        public Object call(Object... args) {
            for (Object arg : args) {
                process((MyResponse(arg));
            }
            return null;
        }
    }).toBlocking().first();