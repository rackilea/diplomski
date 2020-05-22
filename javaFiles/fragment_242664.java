log4j.logger.com.yourpackage.yourclass=INFO, YourLoggerName

log4j.appender.YourLoggerName=org.apache.log4j.RollingFileAppender
log4j.appender.YourLoggerName.File=/path/to/logfile/forthisappender
log4j.appender.YourLoggerName.MaxFileSize=5M
log4j.appender.YourLoggerName.MaxBackupIndex=10
log4j.appender.YourLoggerName.layout=org.apache.log4j.PatternLayou
log4j.appender.YourLoggerName.layout.ConversionPattern=%d{yyyy-MM-dd HH:mm:ss} [%t] %-5p %c{1}:%L - %m%n