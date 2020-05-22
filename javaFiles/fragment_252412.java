buildscript {
    repositories {
        mavenCentral()
    }
    dependencies {
        classpath("org.springframework.boot:spring-boot-gradle-plugin:1.3.1.RELEASE")
    }
}

apply plugin: 'spring-boot'
apply plugin: 'eclipse'

jar {
    baseName = 'open-secret'
    version = '0.0.1-SNAPSHOT'
}

repositories {
    mavenCentral()
}

ext['hibernate.version'] = '5.0.7.Final'

dependencies {
    compile("org.springframework.boot:spring-boot-starter-actuator")
    compile("org.springframework.boot:spring-boot-starter-web")
    compile("org.springframework.boot:spring-boot-starter-data-jpa")
    compile("org.springframework.boot:spring-boot-starter-security")
    compile("mysql:mysql-connector-java")
    testCompile("org.springframework.boot:spring-boot-starter-test")
}


eclipse {
    classpath {
         containers.remove('org.eclipse.jdt.launching.JRE_CONTAINER')
         containers 'org.eclipse.jdt.launching.JRE_CONTAINER/org.eclipse.jdt.internal.debug.ui.launcher.StandardVMType/JavaSE-1.8'
    }
}