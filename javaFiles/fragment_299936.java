#Root Logger Option
log4j.rootLogger=INFO,myConsoleAppender,myAppender

## Redirect log messages to console
log4j.appender.myConsoleAppender=org.apache.log4j.ConsoleAppender
log4j.appender.myConsoleAppender.layout=org.apache.log4j.PatternLayout
log4j.appender.myConsoleAppender.layout.ConversionPattern=%d{yyyy-MM-dd@HH:mm:ss} %5p - %m%n
log4j.appender.myAppender=org.apache.log4j.RollingFileAppender

## Redirect log messages to a log file 
log4j.appender.myAppender.File=${catalina.home}/logs/someFileName.log
log4j.appender.myAppender.MaxBackupIndex=1
log4j.appender.myAppender.MaxFileSize=1000KB
log4j.appender.myAppender.layout=org.apache.log4j.PatternLayout
log4j.appender.myAppender.layout.ConversionPattern=%d{yyyy-MM-dd@HH\:mm\:ss} %-5p - %m%n