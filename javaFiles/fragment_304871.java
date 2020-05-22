1   <?xml version="1.0" encoding="UTF-8"?>
2   <Configuration status="warn" name="MyApp" packages="">
3     <Appenders>
4       <RollingFile name="RollingFile" fileName="logs/app.log"
5                    filePattern="logs/$${date:yyyy-MM}/app-%d{MM-dd-yyyy}-%i.log.gz">
6         <PatternLayout>
7           <Pattern>%d %p %c{1.} [%t] %m%n</Pattern>
8         </PatternLayout>
9         <Policies>
10          <TimeBasedTriggeringPolicy />
11          <SizeBasedTriggeringPolicy size="10 MB"/>
12        </Policies>
13        <DefaultRolloverStrategy max="2"/>
14      </RollingFile>
15    </Appenders>
16    <Loggers>
17      <Root level="error">
18        <AppenderRef ref="RollingFile"/>
19      </Root>
20    </Loggers>
21  </Configuration>