spring:
  datasource:
    url: jdbc:h2:mem:testdb;DB_CLOSE_DELAY=-1;DB_CLOSE_ON_EXIT=FALSE;MODE=Oracle
    username: sa
    password:
    platform: h2
    driver-class-name: org.h2.Driver
  jpa:
    properties:
      hibernate:
        dialect: org.hibernate.dialect.H2Dialect
    hibernate:
      ddl-auto: none
    generate-ddl: true

liquibase:
  url: ${spring.datasource.url}
  contexts: test
  change-log: classpath:liquibase/test-master.xml
  user: sa
  password: