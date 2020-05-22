public class RequestHandler extends DefaultHttpRequestHandler {
    @Override
    public Action createAction(Http.Request request, Method actionMethod) {
        return new Action.Simple() {
            @Override
            public F.Promise<Result> call(Http.Context ctx) throws Throwable {
                // if the action is annotated with @NoAuthRequired or user is logged in delegate to it
                if (actionMethod.isAnnotationPresent(NoAuthRequired.class) || ctx.session().containsKey("loggedIn")) {
                    return delegate.call(ctx);
                }
                // otherwise, block access
                else {
                    return F.Promise.pure(forbidden("You're not allowed"));
                }
            }
        };
    }
}