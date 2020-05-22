repositories {
    prebuilt(PrebuiltLibraries) {
        YourLib {
            binaries.withType(SharedLibraryBinary) {
                sharedLibraryFile = file("src/main/libs/armeabi-v7a/libYourLib.so")
            }
        }
    }
}

android.sources {
    main {
        jniLibs {
            dependencies {
                library "YourLib"
            }
        }
    }
}