import org.apache.camel.LoggingLevel;
import org.apache.camel.builder.RouteBuilder;

import java.util.UUID;

public class UuidLogger extends RouteBuilder {
    private final String loggerID = getClass().getName();

    @Override
    public void configure() throws Exception {
        from("direct:uuidLogger").routeId("uuidLogger")
                .log(LoggingLevel.INFO, loggerID, "UuidLogger triggered with $simple{body}, headers: $simple{headers}")
                .onException(Exception.class)
                    .log(LoggingLevel.ERROR, loggerID, "Fail: Exception. Body: $simple{body}, Headers: $simple{headers}, Stacktrace: $simple{exception.stacktrace}")
                    .handled(true)
                .end()
                .bean(UuidGenerator.class)
                .log(LoggingLevel.INFO, loggerID, "Generated UUID: $simple{body}")
                .to("mock:uuidLoggerMock")
                .log(LoggingLevel.INFO, loggerID, "UuidLogger done");
    }
}