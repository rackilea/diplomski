<appender name="stdout" class="org.apache.log4j.ConsoleAppender">
    <layout class="org.apache.log4j.PatternLayout">
        <param name="ConversionPattern" value="%d{MMM dd HH:mm:ss} %F: %m%n" />
    </layout>
</appender>

<appender name="rolling" class="org.apache.log4j.RollingFileAppender">
    <param name="FileName" value="/tomcat/website/webapps/app/logs/app.log" />
    <param name="MaxFileSize" value="1000KB" />
    <param name="MaxBackupIndex" value="2" />
    <layout class="org.apache.log4j.PatternLayout">
        <param name="ConversionPattern" value="%d{MMM dd HH:mm:ss} %F: %m%n" />
    </layout>
</appender>