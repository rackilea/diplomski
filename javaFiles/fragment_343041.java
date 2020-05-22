### Direct log4j properties to STDOUT ###  
log4j.appender.stdout=org.apache.log4j.ConsoleAppender  
log4j.appender.stdout.Target=System.out  
log4j.appender.stdout.layout=org.apache.log4j.PatternLayout  
log4j.appender.stdout.layout.ConversionPattern=%d{ABSOLUTE} %5p %c{1}:%L - %m%n  

### Set Log Levels - ###  
log4j.rootLogger=warn, stdout  
log4j.logger.org.hibernate=info  

### Log JDBC Bind Parameters ###  
log4j.logger.org.hibernate.type=debug  

### Log schema/export update ###  
log4j.logger.org.hibernate.tool.hbm2ddl=debug