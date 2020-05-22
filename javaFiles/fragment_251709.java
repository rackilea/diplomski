<RollingFile 
    name="FILE" fileName="/logs/app-${date:yyyy-MM-dd'_'HH-mm-ss}.log" 
    filePattern="logs/app-%d{yyyy-MM-dd}-%i.log"
    ignoreExceptions="false">
        <PatternLayout>
            <Pattern>%d{yyyy-MM-dd'_'HH-mm-ss} %p %m%n</Pattern>
        </PatternLayout>
        <TimeBasedTriggeringPolicy />
</RollingFile>