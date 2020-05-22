repositories {
    mavenCentral()
}

apply plugin: 'java'
apply plugin: 'jacoco'
apply plugin: 'sonar-runner'


sourceCompatibility = 1.7
project.version = '1.0'
project.group = 'com.acme.sandbox'
project.description = 'just a test project'

dependencies {
    testCompile group: 'junit', name: 'junit', version: '4.11'
}

// JaCoCo test coverage configuration
tasks.withType(Test) { task ->
    jacoco {
        append = false
    }
}

// Sonar configuration
sonarRunner {
    sonarProperties {
        // general information about the SonarQube server
        property 'sonar.host.url', 'http://localhost:9000'
        property 'sonar.jdbc.url', 'jdbc:h2:tcp://localhost:9092/sonar'
        property 'sonar.jdbc.validationQuery', 'select 1'
        property 'sonar.jdbc.driverClassName', 'org.hibernate.dialect.H2Dialect'
        property 'sonar.jdbc.password', 'sonar'
        property 'sonar.jdbc.password', 'sonar'
        property 'sonar.login', 'jenkins'
        property 'sonar.password', 'jenkins'

        // information about this project
        //property 'sonar.profile', 'profilename'
        property 'sonar.branch', 'DEV'
        property 'sonar.language', 'java'
        property 'sonar.sourceEncoding', 'UTF-8'
        property 'sonar.verbose', 'true'
        //property 'sonar.tests', "$projectDir\\src\\test\\java"
        property 'sonar.binaries', "${buildDir}/classes/main/"

        // execute JaCoCo before the SonarQube run to have report file ready
        //property 'sonar.java.coveragePlugin', 'jacoco'
        property 'sonar.jacoco.reportPath', "${buildDir}/jacoco/test.exec"
        property 'sonar.junit.reportsPath', "${buildDir}/test-results"
    }
}