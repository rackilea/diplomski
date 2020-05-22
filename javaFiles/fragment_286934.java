<!--  Configuration for your local environment -->
<springProfile name="${user.name}">
    <root level="DEBUG">
        <appender-ref ref="ROLLING_FILE" />
    </root>
</springProfile>

<appender name="ROLLING_FILE" class="ch.qos.logback.core.rolling.RollingFileAppender">
    ...
</appender>


<!-- Configuration for Development Environment --> 
<springProfile name="dev">
    <include resource="logback-prod.xml" />
</springProfile>