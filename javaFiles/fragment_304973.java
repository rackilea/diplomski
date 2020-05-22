static Observable<String> callExternalUrlAsync(String url, String json, HttpMethod method)
{
    return Observable.fromCallable(() -> callExternalUrl(url, json, method))
            .subscribeOn(Schedulers.io())
            .flatMap(re -> {
                         if (re.hasBody())
                             return Observable.just(re.getBody());
                         else
                             return Observable.error(new RuntimeException("Bad response status " + re.getStatusCode()));
                     },
                     e -> Observable.error(e),
                     (Func0<Observable<? extends String>>) (() -> Observable.empty())) // I need explicit cast or it won't compile :-(
            .observeOn(Schedulers.computation());
}