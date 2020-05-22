package controllers;

import java.util.HashMap;
import java.util.Map;
import play.libs.F;
import play.libs.Json;
import play.libs.ws.WS;
import play.libs.ws.WSResponse;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Results;

public class Application extends Controller {

    public F.Promise<Result> index() {
        final long start = System.currentTimeMillis();
        final F.Function<WSResponse,Long> timing = response -> System.currentTimeMillis() - start;

        return F.Promise.sequence(WS.url("http://www.google.com").get().map(timing),
                                  WS.url("http://www.yahoo.com").get().map(timing),
                                  WS.url("http://www.bing.com").get().map(timing))
                        .map(list -> {
                            Map<String, Long> data = new HashMap<>();
                            data.put("google", list.get(0));
                            data.put("yahoo", list.get(1));
                            data.put("bing", list.get(2));
                            return data;
                        })
                        .map(Json::toJson)
                        .map(Results::ok);
    }

}