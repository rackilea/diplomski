<appender name="out" class="org.apache.log4j.RollingFileAppender">
    <param name="File" value="${openfireHome}/logs/out.log" />
    <param name="MaxFileSize" value="1024KB"/>
    <param name="MaxBackupIndex" value="5"/>
    <layout class="org.apache.log4j.PatternLayout">
        <param name="ConversionPattern" value="%d [%t] %-7p %10c{1} - %m%n" />
    </layout>
</appender>