observableList.flatMap(incentiveDetailsList -> {
    List<SomeObject> list = mapThisList(incentiveDetailsList);
    return Observable.from(list)
           .flatMap(item -> {
               Request request = createRequest(item);
               String accountNumber = item.getAccountNumber();
               return serviceThatReturnsObservable.load(request)
                   /* this has no effect:
                            .doOnError(onError -> {
                                Observable.error(new Exception("some context"));
                            })
                    */
                    .map(response -> {
                         handleError(response);
                         return responseMap.put(accountNumber, 
                            buildResponse(response.getResponse()));
                    });
            })
            .map(resp -> mapResponse(store, incentiveDetailsList, responseMap));
})