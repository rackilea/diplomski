public class VerboseAction extends play.mvc.Action.Simple {
    public CompletionStage<Result> call(Http.Context ctx) {
        Logger.info("Calling action for {}", ctx);
        return delegate.call(ctx);
    }
}