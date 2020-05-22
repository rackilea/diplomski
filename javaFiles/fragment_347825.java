import org.apache.http.NameValuePair;
import org.apache.http.client.utils.URLEncodedUtils;
import java.nio.charset.Charset;
import java.util.List;

public class UrlParsing {
    public static void main(String[] a){
        String url="http://mysite.com/index.php?name=john&id=42";
        List<NameValuePair> args= URLEncodedUtils.parse(url, Charset.defaultCharset());
        for (NameValuePair arg:args)
            if (arg.getName().equals("id"))
                System.out.println(arg.getValue());
    }
}