subprojects {
afterEvaluate {
    project -> if (project.hasProperty("android")) {
        android {
            compileSdkVersion 28
            buildToolsVersion '28.0.0'
        }
    }
}