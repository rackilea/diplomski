// Universal wrapper method
static <T> Observable<T> wrapCallExternalAsAsync(Func3<String, String, HttpMethod, ResponseEntity<T>> externalCall, String url, String json, HttpMethod method)
{
    return Observable.fromCallable(() -> externalCall.call(url, json, method))
            .subscribeOn(Schedulers.io())
            .flatMap(re -> {
                         if (re.hasBody())
                             return Observable.just(re.getBody());
                         else
                             return Observable.error(new RuntimeException("Bad response status " + re.getStatusCode()));
                     },
                     e -> Observable.error(e),
                     (Func0<Observable<? extends T>>) (() -> Observable.empty())) // I need explicit cast or it won't compile :-(
            .observeOn(Schedulers.computation());
}

static Observable<String> callExternalUrlAsync_HigherOrder(String url, String json, HttpMethod method)
{
    return wrapCallExternalAsAsync(MyClass::callExternalUrl, url, json, method);
}