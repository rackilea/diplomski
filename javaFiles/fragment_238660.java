import us.monoid.web.Resty;
import static us.monoid.web.Resty.*;

Resty r = new Resty();
String result = r.text(config.getServerUrl(), 
       form(data("MAX_FILE_SIZE","256"), 
            data("stats", "wsum"),...etc.etc.).toString();