appenders = csvFile

appender.csvFile.type = RollingFile
appender.csvFile.name = CSVFILE
appender.csvFile.fileName = csvLog.tmp
appender.csvFile.filePattern= csvLog-%d{MM-dd-yyyy}-%i.csv
appender.csvFile.layout.type = CsvParameterLayout
appender.csvFile.layout.delimiter = ,
appender.csvFile.layout.header = column1,column2,column3\n
appender.csvFile.policies.type = Policies
appender.csvFile.policies.time.type = TimeBasedTriggeringPolicy
appender.csvFile.policies.time.interval = 1
appender.csvFile.policies.time.modulate = true
appender.csvFile.policies.size.type = SizeBasedTriggeringPolicy
appender.csvFile.policies.size.size=10MB
appender.csvFile.strategy.type = DefaultRolloverStrategy
appender.csvFile.strategy.max = 200

rootLogger.level = debug
rootLogger.appenderRefs = csvFile
rootLogger.appenderRef.csvFile.ref = CSVFILE