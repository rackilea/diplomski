public static Result espnRss() {
    // do request
    return async(
        WS.url("http://espnfc.com/rss/news?section=premierleague").setTimeout(100).get().map(
            new F.Function<WS.Response, Result>() {
                @Override
                public Result apply(WS.Response response) throws Throwable {
                    return ok("Success!"); // success request
                }
            }
        ).recover( // to handle error occured on redeemed PROMISE
            new F.Function<Throwable, Result>() {
                @Override
                public Result apply(Throwable throwable) throws Throwable {
                    // option to distinguish exception
                    if (throwable instanceof TimeoutException) {
                        return internalServerError("Oops, time out exception occured!");
                    } else {
                        return internalServerError("Oops, other exception occured!");
                    }
                }
            }
        )
    );
}