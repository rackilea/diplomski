<configuration>
  <appender name="STDOUT" class="ch.qos.logback.core.ConsoleAppender"> 
    <encoder>
      <pattern>[%thread] %-5level - %msg%n%rEx{full, bar}</pattern>
    </encoder>
  </appender>
  ...
</configuration>