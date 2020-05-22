<appender name="FILE" class="ch.qos.logback.core.FileAppender">
    <file>${application.home:-.}/logs/application.log</file>
    <filter class="ch.qos.logback.classic.filter.ThresholdFilter">
        <level>DEBUG</level>
    </filter>
    <encoder>
        <pattern>[%d{HH:mm:ss}] [%level] - %message%n%xException</pattern>
    </encoder>
    <append>true</append>
</appender>