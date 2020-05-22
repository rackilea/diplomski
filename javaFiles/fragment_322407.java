log4j.appender.stdout=org.apache.log4j.ConsoleAppender
log4j.appender.stdout.follow=true
log4j.appender.stdout.layout=org.apache.log4j.PatternLayout
log4j.appender.stdout.layout.ConversionPattern=%d{ISO8601} | %-5.5p | %-16.16t | %-32.32c{1} | %-64.64C %4L | %m%n

log4j.rootLogger=error, stdout
log4j.logger.com.company.app.interesting.module=debug
...