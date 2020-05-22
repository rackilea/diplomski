import java.net.URL;
import org.apache.log4j.helpers.OptionConverter;
import org.apache.log4j.LogManager;

public aspect Log4jAspect {
    before(URL defaultURL) :
        within(LogManager) &&
        cflow(staticinitialization(LogManager)) &&
        call(* OptionConverter.selectAndConfigure(URL, ..)) &&
        args(defaultURL, ..)
    {
        System.out.println("log4j default URL = " + defaultURL);
    }
}