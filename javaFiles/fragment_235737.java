public class Application extends Controller {

    private WSClient ws;

    @Inject
    public Application(WSClient ws) {

        this.ws = ws;
        WSRequest request = this.ws.url("https://...");

        ...
    }
}