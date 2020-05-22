<logger name="AUDIT_LOGGER" level="info" additivity="false">
    <appender name="STDOUT" class="ch.qos.logback.core.ConsoleAppender">
        <encoder>
            <pattern>%d{HH:mm:ss.SSS}|%msg%n
            </pattern>
        </encoder>
    </appender>
</logger>