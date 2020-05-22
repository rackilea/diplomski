package controllers;

import play.libs.ws.WSClient;
import play.mvc.Controller;
import play.mvc.Result;

import java.util.concurrent.CompletionStage;
import javax.inject.Inject;


public class HomeController extends Controller {

    @Inject WSClient ws;

    public CompletionStage<Result> index() {
        return ws
          .url("http://www.maine-coon-cat-nation.com/image-files/orange-maine-coon-cat.jpg")
          .get()
          .thenApply(file -> ok(file.getBodyAsStream()).as("image/jpeg"));
    }

}