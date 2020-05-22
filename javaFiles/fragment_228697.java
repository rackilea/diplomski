<Console name="info-stdout-message">
    <PatternLayout pattern="[%logger{36}] %message %n" />
    <Filters>

        <!-- Now deny warn, error and fatal messages -->
        <ThresholdFilter level="warn"  onMatch="DENY"   onMismatch="NEUTRAL"/>

        <!-- This filter accepts info, warn, error, fatal and denies debug/trace -->
        <ThresholdFilter level="info"  onMatch="ACCEPT" onMismatch="DENY"/>
    </Filters>
</Console>