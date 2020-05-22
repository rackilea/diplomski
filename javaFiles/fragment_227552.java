private Observable<String> makeRequestToServiceA() {
    return Observable.just("serviceA response"); //some network call
}

private Observable<String> makeRequestToServiceB(String serviceAResponse) {
    return Observable.just("serviceB response"); //some network call based on response from ServiceA
}

private void doTheJob() {
    makeRequestToServiceA()
            .flatMap(new Func1<String, Observable<? extends String>>() {
                @Override
                public Observable<? extends String> call(String responseFromServiceA) {
                    //make second request based on response from ServiceA
                    return makeRequestToServiceB(responseFromServiceA);
                }
            }, new Func2<String, String, Observable<String>>() {
                @Override
                public Observable<String> call(String responseFromServiceA, String responseFromServiceB) {
                    //combine results
                    return Observable.just("here is combined result!");
                }
            })
            //apply schedulers, subscribe etc
}