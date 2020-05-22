import play.twirl.api.Html;

//....

public static Result bar() {
    return ok(bar.render(Html.apply("<h1>Bar</h1>")));
}