<included>

    <!-- put your appenders -->
    <appender name="CONSOLE" class="ch.qos.logback.core.ConsoleAppender">
    <!-- encoders are assigned the type
     ch.qos.logback.classic.encoder.PatternLayoutEncoder by default -->
       <encoder>
           <pattern>%d{ISO8601} %p %t %c{0}.%M - %m%n</pattern>
           <charset>utf8</charset>
        </encoder>
    </appender>

    <!-- put your loggers here -->
    <logger name="org.springframework.web" additivity="false" level="INFO">
        <appender-ref ref="CONSOLE" />
    </logger>

    <!-- put your root here -->
    <root level="warn">
        <appender-ref ref="CONSOLE" />
    </root>

</included>