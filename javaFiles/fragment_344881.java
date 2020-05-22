apply plugin: 'com.android.application'

apply plugin: 'kotlin-android'

apply plugin: 'kotlin-android-extensions'

apply plugin: 'com.google.protobuf'

android {
    compileSdkVersion 26
    ext.buildType =  ""
    defaultConfig {
        applicationId "com.my.appr"
        minSdkVersion 15
        targetSdkVersion 26
        versionCode 1
        versionName "1.0"
        testInstrumentationRunner "android.support.test.runner.AndroidJUnitRunner"
    }
    buildTypes {
        release {
            buildType = "Release"
            minifyEnabled false
            proguardFiles getDefaultProguardFile('proguard-android.txt'), 'proguard-rules.pro'
        }
        debug {
            buildType = "Debug"
        }
    }
    sourceSets {
        debug.java.srcDirs += 'build/generated/source/proto/debug/java'
        debug.java.srcDirs += 'build/generated/source/proto/debug/grpc'
        debug.java.srcDirs += 'build/generated/source/proto/debug/javalite'
        release.java.srcDirs += 'build/generated/source/proto/release/java'
        release.java.srcDirs += 'build/generated/source/proto/release/grpc'
        release.java.srcDirs += 'build/generated/source/proto/release/javalite'
        main.proto.srcDirs += 'src/main/proto'
    }
    //preBuild.dependsOn(":generateDebugProto")
}


protobuf {
    protoc {
        artifact = 'com.google.protobuf:protoc:3.5.0'
    }
    plugins {
        javalite {
            artifact = "com.google.protobuf:protoc-gen-javalite:3.0.0"
        }
        grpc {
            artifact = 'io.grpc:protoc-gen-grpc-java:1.8.0' // CURRENT_GRPC_VERSION
        }
    }
    generateProtoTasks {
        all().each { task ->
            task.builtins {    ///////////////////////////////7
                remove java    // THIS IS THE SOLUTION      //
            }                  ///////////////////////////////
            task.plugins {
                javalite {}
                grpc {
                    // Options added to --grpc_out
                    option 'lite'
                }
            }
        }
    }
}

dependencies {
    implementation fileTree(dir: 'libs', include: ['*.jar'])
    implementation"org.jetbrains.kotlin:kotlin-stdlib-jre7:$kotlin_version"
    implementation 'com.android.support:appcompat-v7:26.1.0'
    implementation 'com.android.support.constraint:constraint-layout:1.0.2'
    testImplementation 'junit:junit:4.12'
    androidTestImplementation 'com.android.support.test:runner:1.0.1'
    androidTestImplementation 'com.android.support.test.espresso:espresso-core:3.0.1'
    implementation 'io.grpc:grpc-okhttp:1.8.0' // CURRENT_GRPC_VERSION
    implementation 'io.grpc:grpc-protobuf-lite:1.8.0' // CURRENT_GRPC_VERSION
    implementation 'io.grpc:grpc-stub:1.8.0' // CURRENT_GRPC_VERSION
    implementation 'javax.annotation:javax.annotation-api:1.2'
}


//preBuild.dependsOn ":generate"+buildType+"proto"