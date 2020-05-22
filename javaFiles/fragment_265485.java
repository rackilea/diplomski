spring:
  cloud:
    gateway:
      discovery:
        locator:
          enabled: true
          predicates:
            - name: Path
              args:
                pattern: "'/api/'+serviceId.toLowerCase()+'/**'"
          filters:
            - name: RewritePath
              args:
                regexp: "'/api/' + serviceId.toLowerCase() + '/(?<remaining>.*)'"
                replacement: "'/${remaining}'"