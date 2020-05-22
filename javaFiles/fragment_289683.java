sourceSets {
        main {
            // let gradle pack the shared library into apk
            jniLibs.srcDirs = ['../path/to/libs']
        }
    }