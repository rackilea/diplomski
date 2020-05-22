<Appenders>
  <RollingFile name="RollingFile" fileName="logs/app.log"
               filePattern="logs/old/app-%d{yyyyMMdd-HHmm}-log.gz">
    <PatternLayout>
      <Pattern>%d %p %c{1.} [%t] %m%n</Pattern>
    </PatternLayout>
    <Policies>
      <TimeBasedTriggeringPolicy />
    </Policies>
  </RollingFile>