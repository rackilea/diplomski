<RollingFile name="DAILY_LOG" fileName="log/daily.log"
                 filePattern="log/%d{ddMMyyyy}_daily.log"
                 >
      <PatternLayout pattern="%d [%7r] %5p - %c - %m%n"/>
      <Policies>
        <TimeBasedTriggeringPolicy interval="1"/>
      </Policies>                               
</RollingFile>