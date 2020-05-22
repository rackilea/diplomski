server:
  port: 8888
spring:
  profiles:
    include: subversion
  cloud:
    config:
      server:
        svn:
          username: configserver
          password: ************
          uri: http://PATH_TO_MY_SVN_SERVER/svn/config
          searchPaths: ["{profile}"]
      discovery:
        enabled: true
  application:
    name: my-server-config