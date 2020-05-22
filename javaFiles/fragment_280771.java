<appender name="MAIN" class="ch.qos.logback.core.rolling.RollingFileAppender">
    <file>${LOG_DIR}/your-app-logs.log</file>
    <rollingPolicy class="ch.qos.logback.core.rolling.TimeBasedRollingPolicy">
        <!-- daily rollover -->
        <fileNamePattern>${LOG_GZ_DIR}/your-app-logs.%d{yyyy-MM-dd}.log.gz</fileNamePattern>
        <!-- keep 90 days' worth of history capped at 3GB total size -->
        <maxHistory>90</maxHistory>
    </rollingPolicy>
</appender>