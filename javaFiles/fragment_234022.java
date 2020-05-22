package foo.bar;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class CxfInterceptorTest {

    private static final String REQ =
            "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:bar=\"http://bar.foo/\">\r\n" +
            "   <soapenv:Header/>\r\n" +
            "   <soapenv:Body>\r\n" +
            "      <bar:echo>\r\n" +
            "         <arg0>\r\n" +
            "            <value1>Hello World</value1>\r\n" +
            "         </arg0>\r\n" +
            "      </bar:echo>\r\n" +
            "   </soapenv:Body>\r\n" +
            "</soapenv:Envelope>";

    @Test
    public void validate() throws Exception {
        String s = call();
        Assert.assertTrue(s.contains("Bye World!"));
    }

    private String call() throws Exception {
        URL url = new URL("http://localhost:9080/InternalActService");
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();

        conn.setDoOutput(true);
        conn.setInstanceFollowRedirects(true);
        conn.setRequestMethod("POST");
        conn.setRequestProperty("Content-Type", "text/xml;charset=UTF-8");
        conn.setRequestProperty("SOAPAction", "");

        OutputStream os = conn.getOutputStream();
        os.write(REQ.getBytes());
        os.flush();
        os.close();

        final int buffSize = 1024;
        byte[] buff = new byte[1024];
        InputStream is = conn.getInputStream();

        StringBuilder builder = new StringBuilder(buffSize);
        for(int readBytes = -1; (readBytes = is.read(buff, 0, buffSize)) != -1; ) {
            builder.append(new String(buff, 0, readBytes));
        }

        is.close();

        return builder.toString();
    }

}