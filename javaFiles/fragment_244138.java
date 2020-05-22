plugins {
    id "com.athaydes.osgi-run" version "1.5.1"
}

repositories {
    mavenLocal()
    jcenter()
}

dependencies {
    osgiRuntime 'org.springframework.ws:spring-ws-core:2.1.1.RELEASE'
}