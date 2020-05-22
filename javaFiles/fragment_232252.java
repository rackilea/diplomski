spring:
  profiles: deployed #Changed this from default to deployed, use deployed when you deploy to jndi datasource  

  datasource:
    jndi-name: jdbc/ourdsname

---
spring:
  profiles: test

  datasource:
    driverClassName: org.h2.Driver
    url: jdbc:h2:mem:testdb;MODE=Oracle