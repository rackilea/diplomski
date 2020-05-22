<appender name="StartupAppender" class="ch.qos.logback.core.rolling.RollingFileAppender">
    <file>${samza.log.dir}/${samza.container.name}-startup.log</file>
    <rollingPolicy class="ch.qos.logback.core.rolling.FixedWindowRollingPolicy">
      <fileNamePattern>${samza.log.dir}/${samza.container.name}-startup.log.%i.log</fileNamePattern>
      <minIndex>1</minIndex>
      <maxIndex>1</maxIndex>
    </rollingPolicy>

    <triggeringPolicy class="ch.qos.logback.core.rolling.SizeBasedTriggeringPolicy">
      <maxFileSize>256MB</maxFileSize>
    </triggeringPolicy>
    <encoder>
      <pattern>%d{yyyy-MM-dd HH:mm:ss.SSS} [%t] %c{1} [%p] %m%n</pattern>
    </encoder>
</appender>

<logger name="STARTUP_LOGGER" additivity="false">
   <level value="info" />
   <appender-ref ref="StartupAppender"/>
</logger>