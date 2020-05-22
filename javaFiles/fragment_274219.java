package controllers;

import models.PingResponse;
import play.data.Form;
import play.libs.F;
import play.mvc.Controller;
import play.mvc.Result;
import play.libs.WS;

public class Ping extends Controller {
    final static String playProxyURL = "http://localhost:9000/"; // pretend this is our proxy domain(should be on port 80)
    final static String couchAppURL = "http://localhost:80/couchappTest/"; // pretend this is our internal secure site
    final static String pingURL = "http://localhost:80/pingTest/"; // pretend this is ping endpoint

    public static Result init() {
        return Ping.useProxy("");
    }

    public static Result useProxy(String assetPath) {

        // request for favicon.ico doesn't include cookie :(
        if (assetPath.equals("favicon.ico")) {
            return ok();
        }
        if (session("authorized") == null || !session("authorized").equals("true")) {
            System.out.println("not auth");
            return redirect(pingURL);
        } else {
            return async(
                    WS.url(couchAppURL + assetPath).get().map(
                            new F.Function<WS.Response, Result>() {
                                public Result apply(WS.Response response) {
                                    return ok(response.getBody()).as(response.getHeader("Content-type"));
                                }
                            }
                    )
            );
        }
    }

    public static Result pingCallbackGET(String token, String httpRef) {
        if (token == null || token.equals("")) {
            return unauthorized();
        } else {
            System.out.println("auth");
            session("authorized", "true");
            session("token", token);
        }
        return redirect(playProxyURL + httpRef);
    }
}