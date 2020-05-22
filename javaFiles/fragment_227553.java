private void doTheJob() {
    makeRequestToServiceA()
            .flatMap(responseFromServiceA -> makeRequestToServiceB(responseFromServiceA),
                    (responseFromServiceA, responseFromServiceB) -> Observable.just("here is combined result!"))
            //...
}