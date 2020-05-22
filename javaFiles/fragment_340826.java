<RollingFile name="appender_1" fileName="/mnt/analytics/logs/others/analytics_.log"
  filePattern="/mnt/analytics/logs/others/analytics_.log.%d{yyyy-MM-dd-HH}">
  <PatternLayout pattern="%d{yyyy-MM-dd HH:mmz}|%m%n"/>
  <Policies>        
    <TimeBasedTriggeringPolicy interval="1"/>
  </Policies>
  <DefaultRolloverStrategy max="24"/>    
</RollingFile>