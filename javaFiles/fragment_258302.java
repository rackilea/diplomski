import java.io.File;
import java.io.IOException;

import org.joox.Match;
import org.xml.sax.SAXException;
import static org.joox.JOOX.$;

public class Main {

    public static void main(String[] args) throws SAXException, IOException {
        final Match $m = $(new File(args[0]));
        $m.find("view").attr("custom:sliderLabel", "Custom SLider Label");
        $m.write(System.out);
    }
}