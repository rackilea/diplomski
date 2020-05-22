# Datasource connection settings to H2 in-memory database
# To init db with h2_init_script.sql add the following to the url : INIT=CREATE SCHEMA IF NOT EXISTS DMDEOWNER\\;SET SCHEMA DMDEOWNER\\;runscript from 'classpath:h2_init_script.sql'
datasources.member-request.url=jdbc:h2:mem:db;DB_CLOSE_DELAY=-1;DB_CLOSE_ON_EXIT=FALSE;IGNORECASE=TRUE;
datasources.member-request.username=sa
datasources.member-request.password=
datasources.member-request.driver-class-name=org.h2.Driver
datasources.member-request.initialize=true

spring.h2.console.enabled=true
spring.h2.console.path=/h2-console
spring.h2.console.settings.web-allow-others=true

spring.jpa.show-sql=true
spring.jpa.hibernate.ddl-auto=update