sonarProperties {
    property "sonar.host.url", "http://sonar.someserver.int"
    property "sonar.jdbc.url", "jdbc:mysql://sonar.someserver.int:3306/sonar"
    property "sonar.jdbc.driverClassName", "com.mysql.jdbc.Driver"
    property "sonar.jdbc.username", "*****"
    property "sonar.jdbc.password", "*****"

    //I added these properties to my gradle.build
    property "sonar.projectKey", "GradleAndroidTest"
    property "sonar.projectName", "GradleAndroidTest"
    property "sonar.projectVersion", "V1.0"
    property "sonar.language", "java"
    property "sonar.sources", "src"
    property "sonar.binaries", "build"
}