<configuration>
    <appender name="MKT-DATA-FIX-LOG" class="ch.qos.logback.core.rolling.RollingFileAppender">
        <file>${LOG_HOME}/mkt-data-fix.log</file>
        <append>false</append>
        <encoder class="ch.qos.logback.classic.encoder.PatternLayoutEncoder">
            <Pattern>%m%n</Pattern>
        </encoder>

        <!-- rollover daily -->
        <rollingPolicy class="com.myapp.logback.MktDataRollingPolicy">
            <fileNamePattern>${LOG_HOME}/archived/foo/mkt-data-fix.%d{yyyy-MM-dd}.%i.gz</fileNamePattern>
            <timeBasedFileNamingAndTriggeringPolicy class="com.mkt.data.CustomTriggerPolicy">
                <maxFileSize>100GB</maxFileSize>
            </timeBasedFileNamingAndTriggeringPolicy>
        </rollingPolicy>
    </appender>
</configuration>