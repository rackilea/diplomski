android {
    .....
    sourceSets.main.jniLibs.srcDir 'src/main/libs'

    // call regular ndk-build(.cmd) script from app directory
    task ndkBuild(type: Exec) {
        workingDir file('src/main')
        commandLine getNdkBuildCmd()
    }

    tasks.withType(JavaCompile) {
        compileTask -> compileTask.dependsOn ndkBuild
    }

    task cleanNative(type: Exec) {
        workingDir file('src/main')
        commandLine getNdkBuildCmd(), 'clean'
    }

    clean.dependsOn cleanNative
}