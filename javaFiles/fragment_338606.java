# Root logger option
log4j.rootLogger=INFO, stdout, file 

# Direct log messages to stdout
log4j.appender.stdout=org.apache.log4j.ConsoleAppender
log4j.appender.stdout.target=System.out 
log4j.appender.stdout.layout=org.apache.log4j.PatternLayout
log4j.appender.stdout.layout.conversionPattern=%d{ABSOLUTE} %5p %t %c{1}:%M:%L - %m%n 

# Direct log messages to a log file
log4j.appender.file=org.apache.log4j.RollingFileAppender
log4j.appender.file.file=logs/myapp_test.log
log4j.appender.file.MaxFileSize=2MB
log4j.appender.file.MaxBackupIndex=1
log4j.appender.file.layout=org.apache.log4j.PatternLayout
log4j.appender.file.layout.conversionPattern=%d{ABSOLUTE} %5p %t %c{1}:%M:%L - %m%n 


# Set the logger level of Console Appender to WARN
log4j.appender.stdout.Threshold = WARN