[INFO] Scanning for projects...
[INFO]                                                                         
[INFO] ------------------------------------------------------------------------
[INFO] Building conFloorApp 1.0.2-SNAPSHOT
[INFO] ------------------------------------------------------------------------
[INFO] 
[INFO] --- maven-dependency-plugin:2.1:tree (default-cli) @ myApp ---
[INFO] localdomain.localhost:myApp:war:1.0.2-SNAPSHOT
[INFO] +- junit:junit:jar:4.8.1:test (scope not updated to compile)
[INFO] +- org.mockito:mockito-all:jar:1.8.4:compile
[INFO] +- org.springframework:spring-test:jar:3.2.8.RELEASE:test
[INFO] |  \- (org.springframework:spring-core:jar:3.2.8.RELEASE:compile - scope updated from test; omitted for duplicate)
[INFO] +- javax.servlet:javax.servlet-api:jar:3.0.1:provided
[INFO] +- javax.servlet.jsp:javax.servlet.jsp-api:jar:2.2.1:provided
[INFO] +- javax.servlet.jsp.jstl:javax.servlet.jsp.jstl-api:jar:1.2.1:compile
[INFO] +- org.glassfish.web:javax.servlet.jsp.jstl:jar:1.2.2:compile
[INFO] +- mysql:mysql-connector-java:jar:5.1.27:provided
[INFO] +- org.springframework:spring-context:jar:3.2.8.RELEASE:compile
[INFO] |  +- org.springframework:spring-aop:jar:3.2.8.RELEASE:compile
[INFO] |  |  +- (aopalliance:aopalliance:jar:1.0:compile - omitted for duplicate)
[INFO] |  |  +- (org.springframework:spring-beans:jar:3.2.8.RELEASE:compile - omitted for duplicate)
[INFO] |  |  \- (org.springframework:spring-core:jar:3.2.8.RELEASE:compile - omitted for duplicate)
[INFO] |  +- org.springframework:spring-beans:jar:3.2.8.RELEASE:compile
[INFO] |  |  \- (org.springframework:spring-core:jar:3.2.8.RELEASE:compile - omitted for duplicate)
[INFO] |  +- (org.springframework:spring-core:jar:3.2.8.RELEASE:compile - omitted for duplicate)
[INFO] |  \- org.springframework:spring-expression:jar:3.2.8.RELEASE:compile
[INFO] |     \- (org.springframework:spring-core:jar:3.2.8.RELEASE:compile - omitted for duplicate)
[INFO] +- org.springframework:spring-core:jar:3.2.8.RELEASE:compile
[INFO] |  \- commons-logging:commons-logging:jar:1.1.3:compile
[INFO] +- org.springframework:spring-web:jar:3.2.8.RELEASE:compile
[INFO] |  +- (org.springframework:spring-aop:jar:3.2.8.RELEASE:compile - omitted for duplicate)
[INFO] |  +- (org.springframework:spring-beans:jar:3.2.8.RELEASE:compile - omitted for duplicate)
[INFO] |  +- (org.springframework:spring-context:jar:3.2.8.RELEASE:compile - omitted for duplicate)
[INFO] |  \- (org.springframework:spring-core:jar:3.2.8.RELEASE:compile - omitted for duplicate)
[INFO] +- org.springframework:spring-webmvc:jar:3.2.8.RELEASE:compile
[INFO] |  +- (org.springframework:spring-beans:jar:3.2.8.RELEASE:compile - omitted for duplicate)
[INFO] |  +- (org.springframework:spring-context:jar:3.2.8.RELEASE:compile - omitted for duplicate)
[INFO] |  +- (org.springframework:spring-core:jar:3.2.8.RELEASE:compile - omitted for duplicate)
[INFO] |  +- (org.springframework:spring-expression:jar:3.2.8.RELEASE:compile - omitted for duplicate)
[INFO] |  \- (org.springframework:spring-web:jar:3.2.8.RELEASE:compile - omitted for duplicate)
[INFO] +- org.springframework:spring-orm:jar:3.2.8.RELEASE:compile
[INFO] |  +- (org.springframework:spring-beans:jar:3.2.8.RELEASE:compile - omitted for duplicate)
[INFO] |  +- (org.springframework:spring-core:jar:3.2.8.RELEASE:compile - omitted for duplicate)
[INFO] |  +- (org.springframework:spring-jdbc:jar:3.2.8.RELEASE:compile - omitted for duplicate)
[INFO] |  \- org.springframework:spring-tx:jar:3.2.8.RELEASE:compile
[INFO] |     +- (org.springframework:spring-beans:jar:3.2.8.RELEASE:compile - omitted for duplicate)
[INFO] |     \- (org.springframework:spring-core:jar:3.2.8.RELEASE:compile - omitted for duplicate)
[INFO] +- org.hibernate:hibernate-core:jar:3.6.3.Final:compile
[INFO] |  +- antlr:antlr:jar:2.7.6:compile
[INFO] |  +- commons-collections:commons-collections:jar:3.1:compile
[INFO] |  +- dom4j:dom4j:jar:1.6.1:compile
[INFO] |  +- org.hibernate:hibernate-commons-annotations:jar:3.2.0.Final:compile
[INFO] |  |  \- (org.slf4j:slf4j-api:jar:1.5.8:compile - omitted for conflict with 1.6.1)
[INFO] |  +- org.hibernate.javax.persistence:hibernate-jpa-2.0-api:jar:1.0.0.Final:compile
[INFO] |  +- javax.transaction:jta:jar:1.1:compile
[INFO] |  \- org.slf4j:slf4j-api:jar:1.6.1:compile
[INFO] +- org.springframework:spring-jdbc:jar:3.2.8.RELEASE:compile
[INFO] |  +- (org.springframework:spring-beans:jar:3.2.8.RELEASE:compile - omitted for duplicate)
[INFO] |  +- (org.springframework:spring-core:jar:3.2.8.RELEASE:compile - omitted for duplicate)
[INFO] |  \- (org.springframework:spring-tx:jar:3.2.8.RELEASE:compile - omitted for duplicate)
[INFO] +- javassist:javassist:jar:3.12.1.GA:compile
[INFO] +- c3p0:c3p0:jar:0.8.4.5:compile
[INFO] +- cglib:cglib:jar:2.2:compile
[INFO] |  \- asm:asm:jar:3.1:compile
[INFO] +- org.springframework.security:spring-security-web:jar:3.2.3.RELEASE:compile
[INFO] |  +- aopalliance:aopalliance:jar:1.0:compile
[INFO] |  +- org.springframework.security:spring-security-core:jar:3.2.3.RELEASE:compile
[INFO] |  |  +- (aopalliance:aopalliance:jar:1.0:compile - omitted for duplicate)
[INFO] |  |  +- (org.springframework:spring-aop:jar:3.2.8.RELEASE:compile - omitted for duplicate)
[INFO] |  |  +- (org.springframework:spring-beans:jar:3.2.8.RELEASE:compile - omitted for duplicate)
[INFO] |  |  +- (org.springframework:spring-context:jar:3.2.8.RELEASE:compile - omitted for duplicate)
[INFO] |  |  +- (org.springframework:spring-core:jar:3.2.8.RELEASE:compile - omitted for duplicate)
[INFO] |  |  \- (org.springframework:spring-expression:jar:3.2.8.RELEASE:compile - omitted for duplicate)
[INFO] |  +- (org.springframework:spring-beans:jar:3.2.8.RELEASE:compile - omitted for duplicate)
[INFO] |  +- (org.springframework:spring-context:jar:3.2.8.RELEASE:compile - omitted for duplicate)
[INFO] |  +- (org.springframework:spring-core:jar:3.2.8.RELEASE:compile - omitted for duplicate)
[INFO] |  +- (org.springframework:spring-expression:jar:3.2.8.RELEASE:compile - omitted for duplicate)
[INFO] |  \- (org.springframework:spring-web:jar:3.2.8.RELEASE:compile - omitted for duplicate)
[INFO] +- org.springframework.security:spring-security-config:jar:3.2.3.RELEASE:compile
[INFO] |  +- (aopalliance:aopalliance:jar:1.0:compile - omitted for duplicate)
[INFO] |  +- (org.springframework.security:spring-security-core:jar:3.2.3.RELEASE:compile - omitted for duplicate)
[INFO] |  +- (org.springframework:spring-aop:jar:3.2.8.RELEASE:compile - omitted for duplicate)
[INFO] |  +- (org.springframework:spring-beans:jar:3.2.8.RELEASE:compile - omitted for duplicate)
[INFO] |  +- (org.springframework:spring-context:jar:3.2.8.RELEASE:compile - omitted for duplicate)
[INFO] |  \- (org.springframework:spring-core:jar:3.2.8.RELEASE:compile - omitted for duplicate)
[INFO] +- org.springframework.security:spring-security-aspects:jar:3.2.3.RELEASE:compile
[INFO] |  +- (org.springframework.security:spring-security-core:jar:3.2.3.RELEASE:compile - omitted for duplicate)
[INFO] |  +- (org.springframework:spring-beans:jar:3.2.8.RELEASE:compile - omitted for duplicate)
[INFO] |  +- (org.springframework:spring-context:jar:3.2.8.RELEASE:compile - omitted for duplicate)
[INFO] |  \- (org.springframework:spring-core:jar:3.2.8.RELEASE:compile - omitted for duplicate)
[INFO] +- javax.mail:mail:jar:1.4:provided
[INFO] |  \- javax.activation:activation:jar:1.1:provided
[INFO] +- com.maxmind.geoip:geoip-api:jar:1.2.11:compile
[INFO] \- com.github.dandelion:datatables-jsp:jar:0.9.3:compile
[INFO]    +- com.github.dandelion:datatables-core:jar:0.9.3:compile
[INFO]    |  +- com.googlecode.json-simple:json-simple:jar:1.1.1:compile
[INFO]    |  |  \- (junit:junit:jar:4.10:compile - omitted for conflict with 4.8.1)
[INFO]    |  +- commons-beanutils:commons-beanutils:jar:1.8.3:compile
[INFO]    |  \- (org.slf4j:slf4j-api:jar:1.7.5:compile - omitted for conflict with 1.6.1)
[INFO]    \- (org.slf4j:slf4j-api:jar:1.7.5:compile - omitted for conflict with 1.6.1)
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time: 1.611s
[INFO] Finished at: Fri May 23 21:55:07 EDT 2014
[INFO] Final Memory: 10M/245M
[INFO] ------------------------------------------------------------------------