package jetty.proxy;

import javax.servlet.ServletException;

import org.eclipse.jetty.client.HttpClient;
import org.eclipse.jetty.proxy.AsyncProxyServlet;

public class MyProxyServlet extends AsyncProxyServlet
{
    @Override
    protected HttpClient createHttpClient() throws ServletException {
        HttpClient client = super.createHttpClient();
        client.setIdleTimeout(44000);
        return client;
    }
}