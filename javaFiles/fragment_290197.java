<RollingFile name="T" fileName="/data_test/log/abc.log"
        filePattern="/data_test/log/abc-%d{MM-dd-yyyy}-%i.log">
        <PatternLayout>
            <Pattern>%d{ISO8601} %-5p [%t] (%F:%L) - %m%n</Pattern>
        </PatternLayout>
        <Policies>              
            <TimeBasedTriggeringPolicy interval="1" modulate="true"/>
            <SizeBasedTriggeringPolicy size="100 KB" />
        </Policies>
    </RollingFile>