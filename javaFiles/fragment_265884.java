<Configuration status="trace">
  <Properties>
    <Property name="logfile">${sys:user.home}/log${date:yyyyMMdd}.log</Property>
  </Properties>
  <Appenders>
    <Console name="STDOUT" target="SYSTEM_OUT">
      <PatternLayout pattern="%m%n"/>
    </Console>
    <File name="FILE" fileName="${sys:logfile}">
      <PatternLayout>
        <pattern>%d %p [%t] %c{1.} %m%n</pattern>
      </PatternLayout>
    </File>
  </Appenders>
  <Loggers>
    <Root level="trace">
      <AppenderRef ref="STDOUT" level="ERROR" />
      <AppenderRef ref="FILE" />
    </Root>
  </Loggers>
</Configuration>