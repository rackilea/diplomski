<Routing name="routing">
        <Routes pattern="$${threadlookup:threadName}">
            <Route>
                <RollingFile name="RollingFile-${threadlookup:threadName}"
                             fileName="${sys:log4j.dir}/thread-${threadlookup:threadName}.log"
                             filePattern="${sys:log4j.dir}/thread-${threadlookup:threadName}-%i.log.gz">
                        <PatternLayout pattern="${logMsgPattern}"/>
                        <Policies>
                            <SizeBasedTriggeringPolicy size="100 MB" />
                        </Policies>
                </RollingFile>
            </Route>
        </Routes>
    </Routing>