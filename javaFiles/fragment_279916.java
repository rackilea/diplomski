<route autoStartup="false" id="get.custkeys">
    <from id="get.custkeys" uri="quartz://autoTokenService/getcustkey?fireNow=true&amp;trigger.repeatInterval=120000&amp;trigger.repeatCount=-1&amp;trigger.misfireInstruction=2"/>
    <process id="get.custkeys.rte" ref="tokenListLookupProcessor"/>
    <split id="splitcustkey">
        <tokenize token=","/>
        <log id="sck1" loggingLevel="INFO" message="Custkey Requesting Token: ${body}"/>
        <process id="supKey" ref="setUpKeysProcessor"/>
        <throttle id="custkey_throttle" timePeriodMillis="1000">
            <constant>1</constant>
            <to id="getKeys" uri="seda:processCustKeys"/>
        </throttle>
    </split>
</route>