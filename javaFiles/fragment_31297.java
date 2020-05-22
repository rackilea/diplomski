public class UserContextInjectingAction extends play.mvc.Action.Simple {

    public F.Promise<SimpleResult> call(Http.Context ctx) throws Throwable {
        Logger.info("Injecting user data into context " + ctx);
        injectUser(ctx); // Written by you
        return delegate.call(ctx);
    }

}