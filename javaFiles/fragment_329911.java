# Production configuration
server:
  port: ${server.web.port}
admin.email: ${admin.email}
#etc
---
spring:
  profiles: dev

security.enable-csrf: false

#other Development configurations