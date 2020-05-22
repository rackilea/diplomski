<Configuration status="WARN"><!-- use TRACE to troubleshoot your config if needed-->
  <Properties>
    <property name="yyyyMMdd">${date:yyyyMMdd}</property>
  </Properties>

  <Appenders>
    <RollingFile name="Application" 
            fileName="${sys:catalina.base}/logs/test${sys:yyyyMMdd}.log"
            filePattern="logs/$${date:yyyy-MM}/app-%d{MM-dd-yyyy}-%i.log.gz">
      <PatternLayout header="File: ${main:--file}">
        <Pattern>%d{yyyy-MM-dd HH:mm} - %m%n</Pattern>
      </PatternLayout>
      <Policies>
        <TimeBasedTriggeringPolicy />
      </Policies>
    </RollingFile>
  <Appenders>

  <Loggers>
    <root level="trace">
      <AppenderRef ref="Application" />
    </root>
  </Loggers>
</Configuration>