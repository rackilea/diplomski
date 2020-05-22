public class Application extends Controller {

    public static Result signin() {
        // ...
        return status(280, "https://api.twitter.com/oauth/authenticate?oauth_token=" + requestToken.getToken());
    }

}