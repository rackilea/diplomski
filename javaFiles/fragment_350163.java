log4j.rootLogger = DEBUG, root


# Root
log4j.appender.root=org.apache.log4j.RollingFileAppender
log4j.appender.root.File=logs/mainLogInheritable.log
log4j.appender.root.Threshold=DEBUG
log4j.appender.root.layout=org.apache.log4j.PatternLayout
log4j.appender.root.layout.ConversionPattern=%d{ISO8601} %-5p 0 %m%n


# A
log4j.appender.myAppenderA=org.apache.log4j.RollingFileAppender
log4j.appender.myAppenderA.File=logs/mylogfileA.log
#log4j.appender.myAppenderA.additivity=false
log4j.appender.myAppenderA.Threshold=DEBUG
log4j.appender.myAppenderA.layout=org.apache.log4j.PatternLayout
log4j.appender.myAppenderA.layout.ConversionPattern=%d{ISO8601} %-5p 0 %m%n


# perf
log4j.appender.perf=org.apache.log4j.RollingFileAppender
log4j.appender.perf.File=logs/perf.log
#log4j.appender.perf.additivity=false
log4j.appender.perf.Threshold=DEBUG
log4j.appender.perf.layout=org.apache.log4j.PatternLayout
log4j.appender.perf.layout.ConversionPattern=%d{ISO8601} %-5p 0 %m%n


 log4j.logger.mypackage.MyClass = DEBUG, myAppenderA
 log4j.logger.perf  = DEBUG, perf

 log4j.additivity.perf = false
 log4j.additivity.mypackage.MyClass = false