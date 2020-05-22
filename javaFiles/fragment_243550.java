log4j.rootLogger = DEBUG, FILEALL, FILEMAIN

log4j.appender.FILEALL=org.apache.log4j.FileAppender
log4j.appender.FILEALL.File=${logfile.name}
log4j.appender.FILEALL.layout=org.apache.log4j.HTMLLayout

log4j.appender.FILEMAIN=org.apache.log4j.FileAppender
log4j.appender.FILEMAIN.File=${logfilemain.name}
log4j.appender.FILEMAIN.layout=org.apache.log4j.HTMLLayout