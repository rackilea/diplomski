<appender name="WSDLR" class="ch.qos.logback.core.RollingFileAppender">
    <file>${dir}/dt_wsdlr.log</file>
    <append>true</append>
    <rollingPolicy class="ch.qos.logback.core.rolling.TimeBasedRollingPolicy">
        <fileNamePattern>${dir}/dt_wsdlr-%d{yyyy.MM.dd}.log</fileNamePattern>
        <maxHistory>90</maxHistory>
        <totalSizeCap>3GB</totalSizeCap>
    </rollingPolicy>

    <encoder>
        <Pattern>${pattern}</Pattern>
    </encoder>
</appender>