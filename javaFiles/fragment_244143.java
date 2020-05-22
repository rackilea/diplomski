plugins {
    id "com.athaydes.osgi-run" version "1.5.1"
}

repositories {
    mavenLocal()
    jcenter()
}

dependencies {
    osgiRuntime 'org.springframework.ws:spring-ws-core:2.1.1.RELEASE'
    osgiRuntime 'org.apache.felix:org.apache.felix.http.servlet-api:1.1.2'
}

runOsgi {
    wrapInstructions {
        printManifests = true
        manifest( 'aopalliance.*' ) {
            instruction 'Export-Package', '*;version=1.0'
        }
        manifest( /commons-logging.*/ ) {
            instruction 'Import-Package', '!javax.servlet,!org.apache.*,*'
            instruction 'Export-Package', '*;version=1.1.1'
        }
    }
}