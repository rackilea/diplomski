artifacts {
    archives(file("${buildDir}/libs/myapp-${version}.jar")) {
        name "myapp"
        classifier ""
    }
}