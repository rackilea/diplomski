status = error
name = PropertiesConfig

#Make sure to change log file path as per your need
property.filename = C:\\logs\\app-info.html

filters = threshold

filter.threshold.type = ThresholdFilter
filter.threshold.level = debug

appenders = rolling

appender.rolling.type = RollingFile
appender.rolling.name = RollingFile
appender.rolling.fileName = ${filename}
appender.rolling.filePattern = debug-backup-%d{MM-dd-yy-HH-mm-ss}-%i.html.gz
appender.rolling.layout.type = HTMLLayout
appender.rolling.layout.charset = UTF-8
appender.rolling.layout.title = Howtodoinjava Info Logs
appender.rolling.layout.locationInfo = true
appender.rolling.policies.type = Policies
appender.rolling.policies.time.type = TimeBasedTriggeringPolicy
appender.rolling.policies.time.interval = 1
appender.rolling.policies.time.modulate = true
appender.rolling.policies.size.type = SizeBasedTriggeringPolicy
appender.rolling.policies.size.size=10MB
appender.rolling.strategy.type = DefaultRolloverStrategy
appender.rolling.strategy.max = 20

loggers = rolling

#Make sure to change the package structure as per your application
logger.rolling.name = com.howtodoinjava
logger.rolling.level = debug
logger.rolling.additivity = false
logger.rolling.appenderRef.rolling.ref = RollingFile