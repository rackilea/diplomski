<appender name="infoFile" class="ch.qos.logback.core.rolling.RollingFileAppender">
  <File>${LOGS_FOLDER}/info.log</File>
  <filter class="ch.qos.logback.classic.filter.LevelFilter">
    <level>INFO</level>
    <onMatch>ACCEPT</onMatch>
    <onMismatch>DENY</onMismatch>
  </filter>
  <encoder>
    <pattern>%d{HH:mm:ss.SSS} [%thread] %-5level %logger{36} - %msg%n</pattern>
  </encoder>
</appender>
<appender name="debugFile" class="ch.qos.logback.core.rolling.RollingFileAppender">
  <File>${LOGS_FOLDER}/debug.log</File>
  <encoder>
    <pattern>%d{HH:mm:ss.SSS} [%thread] %-5level %logger{36} - %msg%n</pattern>
  </encoder>
</appender>

<root level="DEBUG"><!-- Using the lowest level here -->
  <appender-ref ref="debugFile" />
  <appender-ref ref="infoFile" />
</root>