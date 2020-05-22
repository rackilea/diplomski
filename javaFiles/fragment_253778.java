<configuration>
  <appender name="STDOUT" class="ch.qos.logback.core.ConsoleAppender">
    <layout class="ch.qos.logback.classic.PatternLayout">
      <Pattern>%d{HH:mm:ss.SSS} [%thread] %-5level %logger{36} - %msg%n</Pattern>
    </layout>
  </appender>

  <appender name="FILE" class="ch.qos.logback.core.FileAppender">
    <File>/tmp/logs/testFile.log</File>
    <Append>true</Append>

    <layout class="ch.qos.logback.classic.PatternLayout">
      <Pattern>%-4relative [%thread] %-5level %logger{35} - %msg%n</Pattern>
    </layout>
  </appender>

  <logger name="com.stackoverflow.q2418355" level="TRACE"/>

  <root level="debug">
    <appender-ref ref="STDOUT" />
    <appender-ref ref="FILE" />
  </root>
</configuration>