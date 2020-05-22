import org.apache.tools.ant.taskdefs.condition.Os

// call regular ndk-build(.cmd) script from app directory
task ndkBuild(type: Exec) {
    if (Os.isFamily(Os.FAMILY_WINDOWS)) {
        commandLine 'ndk-build.cmd', '-C', file('src/main').absolutePath
    } else {
        commandLine 'ndk-build', '-C', file('src/main').absolutePath
    }
}

tasks.withType(JavaCompile) {
    compileTask -> compileTask.dependsOn ndkBuild
}