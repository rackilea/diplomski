# Root logger option
log4j.rootLogger=INFO, logg

log4j.appender.logg=org.apache.log4j.RollingFileAppender
log4j.appender.logg.File=.\\Logs\\Testlogs.log
log4j.appender.logg.MaxFileSize=5MB
log4j.appender.logg.MaxBackupIndex=3
log4j.appender.logg.layout=org.apache.log4j.PatternLayout
log4j.appender.logg.layout.ConversionPattern=%d{yyyy-MM-dd HH:mm:ss} %-5p %c{1}:%L - %m%n