public class Application extends Controller {

    @Before
    static void log0() {Logger.info("before: "+ response.out.size());}
    @After
    static void log1() {Logger.info("After: "+ response.out.size());}
    @Finally
    static void log2() {Logger.info("finally: "+ response.out.size());}

    public static void index() {
        Logger.info("in index action");
        render();
    }
}