<File name="AuditFile" fileName="myapp-audit.log">
    <PatternLayout 
       pattern="%d{yyyy-mm-dd HH:mm:ss.SSS} [%t] %-5level %logger{36} - %msg%nZ" />
    <Filters>

        <!-- First deny warn, error and fatal messages -->
        <ThresholdFilter level="warn"  onMatch="DENY" onMismatch="NEUTRAL"/>
        <ThresholdFilter level="error" onMatch="DENY" onMismatch="NEUTRAL"/>
        <ThresholdFilter level="fatal" onMatch="DENY" onMismatch="NEUTRAL"/>

        <!-- Then accept info, warn, error, fatal and deny debug/trace -->
        <ThresholdFilter level="info"  onMatch="ACCEPT" onMismatch="DENY"/>
    </Filters>
</File>