import org.apache.camel.Produce;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.builder.AdviceWithRouteBuilder;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.http.common.HttpOperationFailedException;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;

public class Http4ExceptionHandlingTest extends CamelTestSupport {

  @Produce(uri = "direct:parent")
  protected ProducerTemplate template;

  @Override
  public boolean isUseAdviceWith() {
    return true;
  }

  @Override
  protected RouteBuilder createRouteBuilder() {
    return new RouteBuilder() {
      @Override
      public void configure() throws Exception {

        onException(HttpOperationFailedException.class)
            .onWhen(exchange -> {
              HttpOperationFailedException
                  exe = exchange.getException(HttpOperationFailedException.class);
              return 204 == exe.getStatusCode();
            })
            .log("HTTP exception handled")
            .handled(true)
            //.continued(true)
            .setBody(constant(null));

        from("direct:parent").routeId("parent")
//            .onException(HttpOperationFailedException.class)
//                .onWhen(exchange -> {
//                  HttpOperationFailedException
//                      exe = exchange.getException(HttpOperationFailedException.class);
//                  return 204 == exe.getStatusCode();
//                })
//                .setBody(constant(null))
//            .end()
            .log("Parent start");
            .to("direct:a")
            .log("Parent done");

        from("direct:a").routeId("a")
            .log("a start")
            .to("http4://localhost:8022/test/service?okStatusCodeRange=200-201")
            .convertBodyTo(String.class)
            .log("a done");
      }
    };
  }

  @Test
  public void testExceptionHandling() throws Exception {
    // comment the following line out if you want to invoke the real service instead!
    weaveRoute();

    context.start();

    Object response = template.requestBody("foo");

    assertThat(response, is(nullValue()));
  }

  @Test
  public void testSuccessfulResponse() throws Exception {
    // comment the following line out if you want to invoke the real service instead!
    weaveRoute();

    context.start();

    Object response = template.requestBody("bar");

    assertThat(response, is(equalTo("bar")));
  }

  private void weaveRoute() throws Exception {
    context.getRouteDefinition("a").adviceWith(context, new AdviceWithRouteBuilder() {
      @Override
      public void configure() throws Exception {
        this.interceptSendToEndpoint("http4*")
            .skipSendToOriginalEndpoint()
            .process(exchange -> {
              String body = exchange.getIn().getBody(String.class);
              if ("foo".equals(body)) {
                Map<String, String> headers = new HashMap<>();
                String location = "";
                HttpOperationFailedException exe =
                    new HttpOperationFailedException("http://bla", 204, "No Content", location,
                                                     headers, "response body");
                throw exe;
              }
            });
      }
    });
  }
}