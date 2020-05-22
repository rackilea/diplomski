<configuration>
    <appender name="ControlAppender" class="org.quackbot.ControlAppender">
        <layout class="class="ch.qos.logback.classic.PatternLayout"">
          <pattern>%d{MM/dd/yyy hh:mm:ss a}  %-5p %c - </pattern>
        </layout>
    </appender>
</configuration>