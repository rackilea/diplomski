<appender name="baseModuleAppender" class="org.apache.log4j.DailyRollingFileAppender">
    <param name="File" value="/var/log/camel/${module}.log" />
    <param name="DatePattern" value="'.'yyyy-MM-dd" />
    <param name="Append" value="true" />
    <param name="Threshold" value="DEBUG" />
    <layout class="org.apache.log4j.PatternLayout">
        <param name="ConversionPattern" value="%d %p [%c] - %m%n" />
    </layout>
</appender>
<logger name="com.package.module.base" additivity="false">
    <level value="DEBUG" />
    <appender-ref ref="baseModuleAppender" />
</logger>