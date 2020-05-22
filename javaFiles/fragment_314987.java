public class GlobalHeaders extends Filter {

@Inject
public GlobalHeaders(Materializer mat) {
    super(mat);
}

@Override
public CompletionStage<Result> apply(
        Function<Http.RequestHeader, CompletionStage<Result>> nextFilter,
        Http.RequestHeader requestHeader) {
    return nextFilter.apply(requestHeader).thenApply(result -> {

        return result.setHeader("Access-Control-Allow-Origin", "*")
          .setHeader("Allow", "*")
          .setHeader("Access-Control-Allow-Methods", "POST, GET, PUT, DELETE, OPTIONS")
          .setHeader("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept, Referer, User-Agent");
    });
}