log4j.rootLogger=DEBUG, console1.out

# CONSOLE is set to be a ConsoleAppender using a PatternLayout.
log4j.appender.console1.out=org.apache.log4j.ConsoleAppender
log4j.appender.console1.out.target=System.out
log4j.appender.console1.out.layout=org.apache.log4j.PatternLayout
log4j.appender.console1.out.layout.ConversionPattern=%d{HH:mm:ss,SSS} - Thread(%5t) - (%F:%L) - %m%n