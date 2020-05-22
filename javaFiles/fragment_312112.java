android {
    ...

    sourceSets {
        main {
            jniLibs.srcDirs = ['jniLibs']
            jni.srcDirs = [] //disable automatic ndk-build
        }
    }
    ndk {
        abiFilters “armeabi-v7a”, ... (what ever other architecture types additional libraries are using)
    }
}

dependencies {
    testCompile 'junit:junit:4.12'
    compile 'com.android.support:appcompat-v7:23.1.1'
    compile 'com.squareup.dagger:dagger:1.2.2'
    compile 'javax.inject:javax.inject:1'
    compile files('libs/Affdex-sdk.jar')
    compile files('libs/Affdex-sdk-javadoc.jar')
}