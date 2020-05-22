log4j.appender.usual=org.apache.log4j.DailyRollingFileAppender
log4j.appender.usual.DatePattern=${roll.pattern.daily}
log4j.appender.usual.layout=org.apache.log4j.PatternLayout
log4j.appender.usual.layout.ConversionPattern=%d{${datestamp}} [%t] %-5p %C{2} - %m%n
log4j.appender.usual.File=usual.log
log4j.appender.usual.Threshold=INFO

log4j.appender.debug=org.apache.log4j.DailyRollingFileAppender
log4j.appender.debug.DatePattern=${roll.pattern.daily}
log4j.appender.debug.layout=org.apache.log4j.PatternLayout
log4j.appender.debug.layout.ConversionPattern=%d{${datestamp}} [%t] %-5p %C{2} - %m%n
log4j.appender.debug.File=debug.log
log4j.appender.debug.Threshold=DEBUG

log4j.logger.customlogger=DEBUG, usual, debug