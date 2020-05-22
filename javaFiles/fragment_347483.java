public static Result feedComments(String feedUrl) {
  return async(
    WS.url(feedUrl).get().flatMap(
      new Function<WS.Response, Promise<Result>>() {
        public Promise<Result> apply(WS.Response response) {
          return WS.url(response.asJson().findPath("commentsUrl").get().map(
            new Function<WS.Response, Result>() {
              public Result apply(WS.Response response) {
                return ok("Number of comments: " + response.asJson().findPath("count"));
              }
            }
          );
        }
      }
    )
  );
}