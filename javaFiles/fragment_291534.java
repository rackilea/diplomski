apply plugin: 'com.android.library'

    android {
        compileSdkVersion 20
        buildToolsVersion "23.0.3"

        defaultConfig {
            minSdkVersion 17
            targetSdkVersion 23

            ndk {
                moduleName "andengine_shared"
            }
        }

        sourceSets {
            main {
                jni.srcDirs = []
                jniLibs.srcDir 'libs'
            }
        }

        buildTypes {
            release {
                minifyEnabled false
                proguardFiles getDefaultProguardFile('proguard-android.txt'), 'proguard-rules.txt'
            }
        }  
    }