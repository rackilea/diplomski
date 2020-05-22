log4j.rootLogger=INFO, stdout, rollingAppender
# Console appender configuration
log4j.appender.stdout=org.apache.log4j.ConsoleAppender
log4j.appender.stdout.layout=org.apache.log4j.PatternLayout
log4j.appender.stdout.layout.ConversionPattern=%-5p: %c - %m%n
log4j.appender.stdout.filter.b=org.apache.log4j.varia.LevelMatchFilter
log4j.appender.stdout.filter.b.LevelToMatch=FATAL    
log4j.appender.stdout.filter.b.AcceptOnMatch=false

#File appender configuration
log4j.appender.rollingAppender=org.apache.log4j.rolling.RollingFileAppender
log4j.appender.rollingAppender.rollingPolicy=org.apache.log4j.rolling.TimeBasedRollingPolicy
log4j.appender.rollingAppender.rollingPolicy.fileNamePattern=F:/temp/app%d{yyyy-MM-dd}.log
log4j.appender.rollingAppender.layout.ConversionPattern= %d %c %M - %m%n
log4j.appender.rollingAppender.layout=org.apache.log4j.PatternLayout
log4j.appender.rollingAppender.ImmediateFlush=true
log4j.appender.rollingAppender.Threshold=FATAL
log4j.appender.rollingAppender.Append=true
log4j.appender.rollingAppender.filter.a=org.apache.log4j.varia.LevelMatchFilter
log4j.appender.rollingAppender.filter.a.LevelToMatch=FATAL    
log4j.appender.rollingAppender.filter.a.AcceptOnMatch=true