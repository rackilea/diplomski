# logj4.properties
log4j.rootCategory = WARN, A
log4j.category.com.lewscanon = WARN, F
log4j.category.com.lewscanon.mouser = DEBUG, X

log4j.appender.A = org.apache.log4j.ConsoleAppender
log4j.appender.A.layout = org.apache.log4j.PatternLayout

log4j.appender.F = org.apache.log4j.RollingFileAppender
log4j.appender.F.layout = org.apache.log4j.PatternLayout
log4j.appender.F.File = /projects/mouser/logs/lewscanon.log
log4j.appender.F.MaxFileSize = 512KB
log4j.appender.F.MaxBackupIndex = 2

log4j.appender.X = org.apache.log4j.RollingFileAppender
log4j.appender.X.layout = org.apache.log4j.PatternLayout
log4j.appender.X.File = /projects/mouser/logs/mouser.log
log4j.appender.X.MaxFileSize = 512KB
log4j.appender.X.MaxBackupIndex = 2

log4j.appender.A.layout.ConversionPattern= %d %-16c{1}:%-39m %-t %x%n
log4j.appender.F.layout.ConversionPattern= %d %-16c{1}:%-39m %-t %x%n
log4j.appender.X.layout.ConversionPattern= %d %-16c{1}:%-39m %-t %x%n