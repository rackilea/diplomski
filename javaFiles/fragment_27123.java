import play.*;
import play.mvc.*;

public class Global extends GlobalSettings {

  private class ActionWrapper extends Action.Simple {
    public ActionWrapper(Action action) {
      this.delegate = action;
    }

    @Override
    public Result call(Http.Context ctx) throws java.lang.Throwable {
      Result result = this.delegate.call(ctx);
      Http.Response response = ctx.response();
      response.setHeader("X-My-Header", "100");
      return result;
    }
  }

  @Override
  public Action onRequest(Http.Request request, java.lang.reflect.Method actionMethod) {
    return new ActionWrapper(super.onRequest(request, actionMethod));
  }

}