import org.apache.tools.ant.taskdefs.condition.Os

...

android {  
  ...
  sourceSets.main {
        jniLibs.srcDir 'src/main/libs' //set .so files location to libs instead of jniLibs
        jni.srcDirs = [] //disable automatic ndk-build call
    }

    // add a task that calls regular ndk-build(.cmd) script from app directory
    task ndkBuild(type: Exec) {
        if (Os.isFamily(Os.FAMILY_WINDOWS)) {
            commandLine 'ndk-build.cmd', '-C', file('src/main').absolutePath
        } else {
            commandLine 'ndk-build', '-C', file('src/main').absolutePath
        }
    }

    // add this task as a dependency of Java compilation
    tasks.withType(JavaCompile) {
        compileTask -> compileTask.dependsOn ndkBuild
    }
}