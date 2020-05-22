<!-- The FILE and ASYNC appenders are here as examples for a production configuration -->
<appender name="FILE" class="ch.qos.logback.core.rolling.RollingFileAppender">
    <rollingPolicy class="ch.qos.logback.core.rolling.TimeBasedRollingPolicy">
        <fileNamePattern>logFile.%d{yyyy-MM-dd}.log</fileNamePattern>
        <maxHistory>90</maxHistory>
    </rollingPolicy>
    <encoder>
        <charset>utf-8</charset>
        <Pattern>%d %-5level [%thread] %logger{0}: %msg%n</Pattern>
    </encoder>
</appender>
<appender name="ASYNC" class="ch.qos.logback.classic.AsyncAppender">
    <queueSize>512</queueSize>
    <appender-ref ref="FILE"/>
</appender>
<root level="${logging.level.root}">
    <appender-ref ref="ASYNC"/>
</root>