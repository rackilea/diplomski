# configure the root logger
log4j.rootLogger=INFO, DAILY

# configure the daily rolling file appender
log4j.appender.DAILY=org.apache.log4j.DailyRollingFileAppender
log4j.appender.DAILY.File=/tmp/log4j/log4jtest.log
log4j.appender.DAILY.DatePattern='.'yyyy-MM-dd
log4j.appender.DAILY.layout=org.apache.log4j.PatternLayout
log4j.appender.DAILY.layout.conversionPattern=%d{yyyy-MM-dd HH:mm:ss.SSS} [%p] %c:%L - %m%n