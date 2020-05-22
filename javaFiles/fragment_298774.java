log4j.appender.DATABASE_RFA=org.apache.log4j.DailyRollingFileAppender
log4j.appender.DATABASE_RFA.File=/path/to/your/log/folder/database-
log4j.appender.DATABASE_RFA.DatePattern='.'yyyy-MM-dd'
log4j.appender.DATABASE_RFA.layout=org.apache.log4j.PatternLayout
log4j.appender.DATABASE_RFA.layout.ConversionPattern=DATABASE | %d{yyyy-MM-dd HH:mm:ss} | %p | %c{1}:%L | %m%n



log4j.logger.DATABASE = info, DATABASE_RFA 
log4j.logger.SECURITY = info, SECURITY_RFA 
log4j.logger.MAIL = info, MAIL_RFA