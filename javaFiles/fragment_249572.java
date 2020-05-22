log4j.logger.org.myproject.loggers.LoggerOne=DEBUG, file1, stdout
log4j.logger.org.myproject.loggers.LoggerTwo=DEBUG, file2, stdout
log4j.logger.org.myproject.loggers.LoggerThree=DEBUG, file3, stdout


# Direct log messages to a log file
log4j.appender.file1=org.apache.log4j.RollingFileAppender
#log4j.appender.TextProcessor.Threshold=debug
log4j.appender.file1.File=E:\\logs\\log1.txt
log4j.appender.file1.MaxFileSize=10MB
log4j.appender.file1.MaxBackupIndex=1
log4j.appender.file1.layout=org.apache.log4j.PatternLayout
log4j.appender.file1.layout.ConversionPattern=%d{HH:mm:ss} %-5p %c{1}:%L - %m%n




# Direct log messages to a log file
log4j.appender.file2=org.apache.log4j.RollingFileAppender
#log4j.appender.TextProcessor.Threshold=debug
log4j.appender.file2.File=E:\\logs\\log2.txt
log4j.appender.file2.MaxFileSize=10MB
log4j.appender.file2.MaxBackupIndex=1
log4j.appender.file2.layout=org.apache.log4j.PatternLayout
log4j.appender.file2.layout.ConversionPattern=%d{HH:mm:ss} %-5p %c{1}:%L - %m%n



# Direct log messages to a log file
log4j.appender.file3=org.apache.log4j.RollingFileAppender
#log4j.appender.TextProcessor.Threshold=debug
log4j.appender.file3.File=E:\\logs\\log3.txt
log4j.appender.file3.MaxFileSize=10MB
log4j.appender.file3.MaxBackupIndex=1
log4j.appender.file3.layout=org.apache.log4j.PatternLayout
log4j.appender.file3.layout.ConversionPattern=%d{HH:mm:ss} %-5p %c{1}:%L - %m%n