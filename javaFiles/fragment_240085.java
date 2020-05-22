package annotations;

import com.fasterxml.jackson.databind.JsonNode;
import play.libs.F;
import play.mvc.Http;
import play.mvc.Result;

public class RequiredJson extends play.mvc.Action.Simple {
    @Override
    public F.Promise<Result> call(Http.Context ctx) throws Throwable {

        boolean hasCorrectType = ctx.request().getHeader("Content-Type") != null && ctx.request().getHeader("Content-Type").equals("application/json");
        JsonNode json = ctx.request().body().asJson();

        if (!hasCorrectType || json == null) {
            return F.Promise.<Result>pure(badRequest("I want JSON!"));
        }
        return delegate.call(ctx);
    }
}