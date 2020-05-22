# configure the root logger
log4j.rootLogger=INFO, SYSLOG, SYSLOG7

# configure Syslog facility LOCAL6 appender
log4j.appender.SYSLOG=org.apache.log4j.net.SyslogAppender
log4j.appender.SYSLOG.threshold=INFO
log4j.appender.SYSLOG.syslogHost=localhost
log4j.appender.SYSLOG.facility=LOCAL6
log4j.appender.SYSLOG.layout=org.apache.log4j.PatternLayout
log4j.appender.SYSLOG.layout.conversionPattern="MyApp: %d\{ISO8601\}%m\n"

# configure Syslog facility LOCAL7 appender
log4j.appender.SYSLOG7=org.apache.log4j.net.SyslogAppender
log4j.appender.SYSLOG7.threshold=ERROR
#                                  vv change to whatever the host is
log4j.appender.SYSLOG7.syslogHost=localhost 
log4j.appender.SYSLOG7.facility=LOCAL7
log4j.appender.SYSLOG7.layout=org.apache.log4j.PatternLayout
log4j.appender.SYSLOG7.layout.conversionPattern="MyApp: %d\{ISO8601\}%m\n"