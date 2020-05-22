<Configuration status="WARN" monitorInterval="30">

    <Properties>
        <Property name="LOG_PATTERN">
            %d{yyyy-MM-dd HH:mm:ss.SSS} %5p ${hostName} --- [%15.15t] %-40.40c{1.} : %m%n%ex
        </Property>
    </Properties>

    <Appenders>
        <Console name="ConsoleAppender" target="SYSTEM_OUT" follow="true">
            <PatternLayout pattern="${LOG_PATTERN}"/>
        </Console>

        <RollingFile name="File-DEBUG" fileName="logs/app-debug.log" filePattern="logs/app-debug-%d{MM-dd-yyyy}.log.gz"
                     ignoreExceptions="false">
            <PatternLayout>
                <Pattern>%d %p %c{1.} [%t] %m%n</Pattern>
            </PatternLayout>
            <TimeBasedTriggeringPolicy/>
            <Filters>
                <ThresholdFilter level="INFO" onMatch="DENY" onMismatch="NEUTRAL"/>
                <ThresholdFilter level="DEBUG" onMatch="ACCEPT" onMismatch="DENY"/>
            </Filters>
        </RollingFile>

        <RollingFile name="File-INFO" fileName="logs/app-info.log" filePattern="logs/app-info-%d{MM-dd-yyyy}.log.gz"
                     ignoreExceptions="false">
            <PatternLayout>
                <Pattern>%d %p %c{1.} [%t] %m%n</Pattern>
            </PatternLayout>
            <TimeBasedTriggeringPolicy/>
            <Filters>
                <ThresholdFilter level="ERROR" onMatch="DENY" onMismatch="NEUTRAL"/>
                <ThresholdFilter level="WARN" onMatch="ACCEPT" onMismatch="NEUTRAL"/>
                <ThresholdFilter level="INFO" onMatch="ACCEPT" onMismatch="DENY"/>
            </Filters>
        </RollingFile>


        <RollingFile name="File-ERROR" fileName="logs/app-error.log" filePattern="logs/app-error-%d{MM-dd-yyyy}.log.gz"
                     ignoreExceptions="false">
            <PatternLayout>
                <Pattern>%d %p %c{1.} [%t] %m%n</Pattern>
            </PatternLayout>
            <TimeBasedTriggeringPolicy/>
            <ThresholdFilter level="ERROR" onMatch="ACCEPT" onMismatch="DENY"/>
        </RollingFile>
    </Appenders>

    <Loggers>
        <Root level="debug">
            <AppenderRef ref="File-INFO"/>
            <AppenderRef ref="File-ERROR"/>
            <AppenderRef ref="File-DEBUG"/>
        </Root>
    </Loggers>
</Configuration>