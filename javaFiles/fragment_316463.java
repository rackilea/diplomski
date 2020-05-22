#logging.level.root=WARN
logging.level.org.springframework=DEBUG
logging.level.com.appicantion.name=DEBUG

#output to a temp_folder/file
logging.file=${java.io.tmpdir}/application.log

# Logging pattern for the console
logging.pattern.console= %d{yyyy-MM-dd HH:mm:ss} - %msg%n

# Logging pattern for file
logging.pattern.file= %d{yyyy-MM-dd HH:mm:ss} [%thread] %-5level %logger{36} - %msg%