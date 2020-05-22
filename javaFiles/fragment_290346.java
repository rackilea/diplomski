@Override
public Publisher<MutableHttpResponse<?>> doFilter(HttpRequest<?> theReq, ServerFilterChain theChain) {
    System.out.println("Filtering!");
    Publisher<MutableHttpResponse<?>> resp = secService.checkAuthorization(theReq)
            .switchMap((authResult) -> { // authResult - is you result from SecurityService
                if (!authResult) {
                    return Publishers.just(HttpResponse.status(HttpStatus.FORBIDDEN)); // reject request
                } else {
                    return theChain.proceed(theReq); // process request as usual
                }
            })
            .doOnNext(res -> {
                System.out.println("Responding!");
            });

    return (resp);
}