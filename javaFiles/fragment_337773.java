<appender name="FILE" class="ch.qos.logback.core.FileAppender">
    <file>path/to/my/file/mylog-${myTimestamp}.log</file>
    <encoder>
        <Pattern>%d{yyyy-MM-dd_HH:mm:ss.SSS} - %msg%n</Pattern>
    </encoder>
</appender>