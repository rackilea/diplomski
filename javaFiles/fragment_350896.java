buildscript {
    ext {
        // Previously using 1.3.1.RELEASE where retry functionality does not work
        springBootVersion = '1.4.0.RELEASE' 
    }
    repositories {
        mavenCentral()
        mavenLocal()
    }
    dependencies {
        classpath("org.springframework.boot:spring-boot-gradle-plugin:${springBootVersion}")
    }
}

apply plugin: 'java'
apply plugin: 'eclipse'
apply plugin: 'spring-boot'

configurations {
   provided
}

sourceSets {
    main {
        compileClasspath += configurations.provided
    }
}

jar {
    baseName = 'load'
    version = '1.0'
}
sourceCompatibility = 1.8
targetCompatibility = 1.8

repositories {
    mavenCentral()
    mavenLocal()
}

dependencies {
    compile('org.springframework.boot:spring-boot-starter-batch')
    compile('org.springframework.boot:spring-boot-configuration-processor')
    compile('org.springframework.boot:spring-boot-starter-data-jpa')
    compile('org.springframework.boot:spring-boot-starter-mail')
    compile('org.springframework.boot:spring-boot-starter-aop')
    compile('org.projectlombok:lombok:1.16.6')
    compile('org.hibernate:hibernate-validator:5.2.4.Final')
    compile('org.quartz-scheduler:quartz:2.2.3')
    runtime('javax.el:javax.el-api:2.2.4')
    runtime('org.glassfish.web:javax.el:2.2.4')
    runtime('net.sourceforge.jtds:jtds:1.3.1')
    testCompile('org.springframework.boot:spring-boot-starter-test')
    testCompile('org.springframework.batch:spring-batch-test')
}



eclipse {
    classpath {
         containers.remove('org.eclipse.jdt.launching.JRE_CONTAINER')
         containers 'org.eclipse.jdt.launching.JRE_CONTAINER/org.eclipse.jdt.internal.debug.ui.launcher.StandardVMType/JavaSE-1.8'
    }
}

task wrapper(type: Wrapper) {
    gradleVersion = '2.11'
}