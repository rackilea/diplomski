import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.webapp.WebAppContext;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.firefox.FirefoxDriver;

import static io.github.seleniumquery.SeleniumQuery.$;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SeleniumAcceptanceTest {
    private static final String WEBAPP_FOLDER = "../../src/main/webapp";
    private static final String APP_CONTEXT = "/myapp";
    private static final int ANY_RANDOM_PORT_AVAIABLE = 0;

    static Server server;
    protected static String urlBase;

    @BeforeClass
    public static void prepareTests() throws Exception {
        startWebAppServer();
        $.browser.setDefaultDriver(new FirefoxDriver());
    }

    @AfterClass
    public static void finalizaTests() {
        $.browser.quitDefaultBrowser();
    }

    private static void levantarServidorDeAplicacao() throws Exception {
        server = new Server(QUALQUER_PORTA_DISPONIVEL);
        String rootPath = SeleniumAcceptanceTest.class.getClassLoader().getResource(".").toString();
        WebAppContext webapp = new WebAppContext(rootPath + WEBAPP_FOLDER , "");
        webapp.setContextPath(APP_CONTEXT );
        server.setHandler(webapp);
        server.start();
        while (true) {
            if (server != null && server.isStarted()) {
                break;
            }
        }
        int port = server.getConnectors()[0].getLocalPort();
        urlBase = "http://localhost:" + port + APP_CONTEXT ;
    }

}