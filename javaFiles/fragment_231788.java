public class Authenticate extends Action<Authentication> {
  public Promise<SimpleResult> call(final Context context) throws Throwable {
    Promise<SimpleResult> result = WS.url(...).get();
    Promise<SimpleResult> result = promise.flatMap( response -> {
      JsonNode user = response.asJson().path("response");
      context.args.put("user", user);
      return delegate.call(context);
    }).map(Promise::pure).recover( e -> {
      return delegate.call(ontext)(routes.Application.index());
    }).flatMap(a -> a);
    return result;
  }
}