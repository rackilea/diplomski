...

import org.apache.http.HttpRequestInterceptor;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.protocol.HttpContext;
import org.apache.http.HttpRequest;
import org.apache.http.HttpException;

... 

builder.addInterceptorFirst(new HttpRequestInterceptor() {

      @Override
      public void process(HttpRequest request, HttpContext context) throws HttpException, IOException {
        // Get hold of the client context, which holds the request config
        RequestConfig requestConfig = HttpClientContext.adapt(context).getRequestConfig();

        assertEquals(10, requestConfig.getConnectTimeout());
        assertEquals(20, requestConfig.getConnectionRequestTimeout());
        assertEquals(30, requestConfig.getSocketTimeout());
      }
    });