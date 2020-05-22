#default settings. these can be overriden for each profile.
#all these settings are overriden by env vars by spring priority
rest:
  api:
    version: 1
base:
   url: /query/api/${rest.api.version}
---
spring:
   profiles: dev
---
spring:
   profiles: production
main:
  show_banner: true
---
spring:
   profiles: test
base:
   url: /query/override/default/value