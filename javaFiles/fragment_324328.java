import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.io.IOUtils;
import org.apache.commons.net.bsd.RExecClient;

public class TestRlogin {

    private RExecClient client;
    private final String url = "test.corp";
    private final String login = "bob";
    private final String password = "bob";

    public TestRlogin() {
        client = new RExecClient();
    }
    public String run(String cmd) throws IOException {
        String res = null;
        InputStream is = null;
        if (client != null) {
            try {
                if (!client.isConnected()) {
                    client.connect(url);
                }
                client.rexec(login, password, cmd);
                is = client.getInputStream();
                if (is != null && is.available() > 0) {
                    res = IOUtils.toString(is);
                } else {
                    System.err.println("InputStream is not available!");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            finally {
                IOUtils.closeQuietly(is);
                client.disconnect();
            }
        } else {
            System.err.println("The RLogin client is not connected to "+url);
        }
        return res;
    }
    public void main(String[] args) {
        TestRlogin trl = new TestRlogin();
        try {
            System.out.println(trl.run("ls -lrt /tmp;"));
            System.out.println(trl.run("tar -xf /tmp/archive.tar;"));
            System.out.println(trl.run("ls -lrt /tmp;"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}