public class Application extends Controller {

    public static Result index() {
        final Set<Map.Entry<String,String[]>> entries = request().queryString().entrySet();
        for (Map.Entry<String,String[]> entry : entries) {
            final String key = entry.getKey();
            final String value = Arrays.toString(entry.getValue());
            Logger.debug(key + " " + value);
        }
        Logger.debug(request().getQueryString("a"));
        Logger.debug(request().getQueryString("b"));
        Logger.debug(request().getQueryString("c"));
        return ok(index.render("Your new application is ready."));
    }
}