buildscript {
    repositories {
        jcenter()
    }
    dependencies {
        classpath 'com.github.jengelman.gradle.plugins:shadow:2.0.4'
        classpath 'de.sebastianboegl.gradle.plugins:shadow-log4j-transformer:2.2.0'
    }
}

apply plugin: 'java'
apply plugin: 'application'
apply plugin: 'eclipse'
apply plugin: 'com.github.johnrengelman.shadow'
archivesBaseName = 'ServerSocket'
version = '3.2.1'

mainClassName = 'br.com.serversocket.main.Main'

compileTestJava {
    sourceCompatibility = 1.8
    targetCompatibility = 1.8
}

compileJava {
    sourceCompatibility = 1.7
    targetCompatibility = 1.7
}

shadowJar {
    //dependsOn 'test'
    transform(de.sebastianboegl.gradle.plugins.shadow.transformers.Log4j2PluginsFileTransformer)
    archiveName = "ServerSocket.jar"

    manifest {
        attributes 'Main-Class': 'br.com.serversocket.main.Main'
    }

    exclude 'META-INF/*.RSA', 'META-INF/*.SF','META-INF/*.DSA'
}

jar {
    //dependsOn 'test'
    archiveName = "ServerSocket.jar"
    from {
        configurations.runtime.collect {
            it.isDirectory() ? it : zipTree(it)
        }

        configurations.compile.collect {
            it.isDirectory() ? it : zipTree(it)
        }
    }

    manifest {
        attributes 'Main-Class': 'br.com.serversocket.main.Main'
    }

    exclude 'META-INF/*.RSA', 'META-INF/*.SF','META-INF/*.DSA'
}

test{
    useJUnitPlatform()
    dependsOn 'cleanTest'

    testLogging {
        events "passed", "skipped", "failed"
    }
    afterTest { desc, result -> 
        logger.quiet "Executing test ${desc.name} [${desc.className}] with result: ${result.resultType}"
    }
    testLogging {
        exceptionFormat = 'full'
    }   
}

eclipse.classpath.file.whenMerged {
  entries.each { println it.path }
}
configurations { 
    providedCompile 
}

repositories {
    mavenCentral()
    mavenLocal()
}

ext {
    jacksonVersion = '2.9.1'
    hibernateVerison = '5.1.0.Final'
    slf4jVerison = '1.7.25'
    log4jVerison = '2.11.1'
    junitVersion = '5.2.0'
    emailVersion = '1.6.1'
    mongoDBVersion = '3.8.0'
}

dependencies {

    //compile files(fileTree(dir: 'lib', includes: ['*.jar']))  
    compile "org.hibernate:hibernate-jpamodelgen:${hibernateVerison}"
    compile "org.hibernate:hibernate-c3p0:${hibernateVerison}"
    compile "org.hibernate:hibernate-core:${hibernateVerison}"
    compile "org.hibernate:hibernate-entitymanager:${hibernateVerison}"

    compile "org.slf4j:slf4j-simple:${slf4jVerison}"
    compile "org.slf4j:slf4j-api:${slf4jVerison}"

    compile "org.apache.logging.log4j:log4j-api:${log4jVerison}"
    compile "org.apache.logging.log4j:log4j-core:${log4jVerison}"
    compile "org.apache.logging.log4j:log4j-mongodb3:${log4jVerison}"


    compile "com.fasterxml.jackson.core:jackson-core:${jacksonVersion}"
    compile "com.fasterxml.jackson.core:jackson-databind:${jacksonVersion}"
    compile "com.fasterxml.jackson.core:jackson-annotations:${jacksonVersion}"
    compile "com.fasterxml.jackson.dataformat:jackson-dataformat-yaml:${jacksonVersion}"

    compile "javax.mail:javax.mail-api:${emailVersion}"
    compile "com.sun.mail:javax.mail:${emailVersion}"

    compile "org.mongodb:mongodb-driver:${mongoDBVersion}"
    compile "org.mongodb:mongodb-driver-core:${mongoDBVersion}"
    compile "org.mongodb:bson:${mongoDBVersion}"


    compile group: 'org.projectlombok', name: 'lombok', version: '1.18.2'
    compile group: 'org.yaml', name: 'snakeyaml', version: '1.21'

    compile group: 'mysql', name: 'mysql-connector-java', version: '5.1.44'
    compile group: 'org.hibernate.common', name: 'hibernate-commons-annotations', version: '5.0.1.Final'
    compile group: 'org.hibernate.javax.persistence', name: 'hibernate-jpa-2.1-api', version: '1.0.2.Final'
    compile group: 'com.mchange', name: 'c3p0', version: '0.9.2.1'
    compile group: 'org.eclipse.persistence', name: 'javax.persistence', version: '2.1.0'
    compile group: 'org.jboss.logging', name: 'jboss-logging', version: '3.3.1.Final'
    compile group: 'commons-logging', name: 'commons-logging', version: '1.0.3'
    compile group: 'org.apache.mina', name: 'mina-core', version: '2.0.19'
    compile group: 'antlr', name: 'antlr', version: '2.7.7'
    compile group: 'com.fasterxml', name: 'classmate', version: '1.3.0'
    compile group: 'commons-codec', name: 'commons-codec', version: '1.11'
    compile group: 'commons-beanutils', name: 'commons-beanutils', version: '1.6'
    compile group: 'commons-collections', name: 'commons-collections', version: '3.2.1'
    compile group: 'org.apache.commons', name: 'commons-email', version: '1.5'
    compile group: 'commons-httpclient', name: 'commons-httpclient', version: '3.1'
    compile group: 'commons-lang', name: 'commons-lang', version: '2.3'
    compile group: 'commons-discovery', name: 'commons-discovery', version: '0.2'
    compile group: 'dom4j', name: 'dom4j', version: '1.6.1'
    compile group: 'net.sf.ehcache', name: 'ehcache', version: '1.5.0'
    compile group: 'org.apache.geronimo.specs', name: 'geronimo-jta_1.1_spec', version: '1.1.1'
    compile group: 'org.jboss', name: 'jandex', version: '2.0.3.Final'
    compile group: 'org.javassist', name: 'javassist', version: '3.22.0-GA'
    compile group: 'jdom', name: 'jdom', version: '1.1'
    compile group: 'javax.transaction', name: 'jta', version: '1.1'
    compile group: 'com.vividsolutions', name: 'jts', version: '1.13'
    compile group: 'org.apache.axis', name: 'axis', version: '1.4'
    compile group: 'axis', name: 'axis-jaxrpc', version: '1.4'
    compile group: 'javax.xml.soap', name: 'saaj-api', version: '1.3'
    compile group: 'wsdl4j', name: 'wsdl4j', version: '1.6.2'
    compile group: 'com.mchange', name: 'mchange-commons-java', version: '0.2.3.4'


    testCompile group: 'com.h2database', name: 'h2', version: '1.4.197'
    testCompile "org.junit.jupiter:junit-jupiter-api:${junitVersion}"
    testCompile "org.junit.jupiter:junit-jupiter-engine:${junitVersion}"
    testCompile "org.junit.jupiter:junit-jupiter-params:${junitVersion}"
    testCompile group: 'org.junit.platform', name: 'junit-platform-launcher', version: '1.2.0'
}

configurations {
    all*.exclude group: 'javassist', module: 'javassist'
}