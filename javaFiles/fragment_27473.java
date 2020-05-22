<appender name="FILE" class="ch.qos.logback.core.FileAppender">
    <file>${catalina.home}/logs/foodini.log</file>
    <append>true</append>
    <encoder class="ch.qos.logback.classic.encoder.PatternLayoutEncoder">
        <Pattern>[%d{dd-MMM-yyyy HH:mm:ss.SSS}] [%logger] [%-5level] - %msg%n</Pattern>
    </encoder>
</appender>

<appender name="HIKARI" class="ch.qos.logback.core.FileAppender">
    <file>${catalina.home}/logs/hikari.log</file>
    <append>true</append>
    <encoder class="ch.qos.logback.classic.encoder.PatternLayoutEncoder">
        <Pattern>[%d{dd-MMM-yyyy HH:mm:ss.SSS}] [%logger] [%-5level] - %msg%n</Pattern>
    </encoder>
</appender>

<logger name="com.zaxxer.hikari" level="ALL" additivity="false">
    <appender-ref ref="HIKARI" />
</logger>

<root level="ALL">
    <appender-ref ref="FILE" />
</root>