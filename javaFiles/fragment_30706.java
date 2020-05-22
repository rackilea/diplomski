import play.api.libs.ws.ahc.AhcWSResponse;
import play.api.libs.ws.ahc.cache.CacheableHttpResponseBodyPart;
import play.api.libs.ws.ahc.cache.CacheableHttpResponseHeaders;
import play.api.libs.ws.ahc.cache.CacheableHttpResponseStatus;
import play.shaded.ahc.io.netty.handler.codec.http.DefaultHttpHeaders;
import play.shaded.ahc.org.asynchttpclient.Response;
import play.shaded.ahc.org.asynchttpclient.uri.Uri;

AhcWSResponse response = new AhcWSResponse(new Response.ResponseBuilder()
        .accumulate(new CacheableHttpResponseStatus(Uri.create("uri"), 200, "status text", "protocols!"))
        .accumulate(new CacheableHttpResponseHeaders(false, new DefaultHttpHeaders().add("My-Header", "value")))
        .accumulate(new CacheableHttpResponseBodyPart("my body".getBytes(), true))
        .build());