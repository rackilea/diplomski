# logger debug
log4j.logger.test.Log4jTestMyBatis=DEBUG, convert
log4j.appender.convert = org.apache.log4j.ConsoleAppender
log4j.appender.convert.layout=org.apache.log4j.PatternLayout
log4j.appender.convert.layout.ConversionPattern=[%d{HH:mm:ss}] %-5p %c{3} %x - %m%n
# end logger debug

# mybatis loggers #
log4j.logger.com.ibatis=DEBUG, convert
log4j.logger.com.ibatis.common.jdbc.SimpleDataSource=DEBUG, convert
log4j.logger.com.ibatis.common.jdbc.ScriptRunner=DEBUG, convert
log4j.logger.com.ibatis.sqlmap.engine.impl.SqlMapClientDelegate=DEBUG, convert