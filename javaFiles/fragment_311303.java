#log4j.rootLogger=INFO, C
log4j.rootLogger=${LOG_LEVEL}, R

# ConsoleAppender for developers
log4j.appender.C=org.apache.log4j.ConsoleAppender
log4j.appender.C.layout=org.apache.log4j.PatternLayout
log4j.appender.C.layout.ConversionPattern=%d [%t] %-5p %c - %m%n

# RollingFileAppender for remote deployments
log4j.appender.R=org.apache.log4j.RollingFileAppender
log4j.appender.R.file=${LOG_HOME}/LogFileName.log
log4j.appender.R.MaxFileSize=${LOG_MAXFILESIZE}
log4j.appender.R.MaxBackupIndex=${LOG_MAXBACKUPINDEX}
log4j.appender.R.layout=org.apache.log4j.PatternLayout
log4j.appender.R.layout.ConversionPattern=%d [%t] %-5p %c - %m%n

log4j.logger.org.hibernate=INFO