apply plugin: 'war'

ext['springVersion'] = '4.2.2.RELEASE'

repositories {
    mavenCentral()
}

dependencies {
    compile "org.springframework:spring-aop:$springVersion"
    compile "org.springframework:spring-webmvc:$springVersion"
    compile 'commons-dbcp:commons-dbcp:1.4'
    compile 'jstl:jstl:1.2'
    providedCompile 'javax.servlet:javax.servlet-api:3.1.0'
}