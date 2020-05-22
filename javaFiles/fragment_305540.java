apply plugin: 'com.android.application'

apply plugin: 'kotlin-android'

apply plugin: 'kotlin-android-extensions'

apply plugin: 'io.fabric'

android {
    compileSdkVersion 28
    buildToolsVersion "28.0.3"

    defaultConfig {
        versionName "2.2.4"
        versionCode 13

        minSdkVersion 16
        targetSdkVersion 27

        testInstrumentationRunner "android.support.test.runner.AndroidJUnitRunner"
        vectorDrawables.useSupportLibrary = true
    }

    buildTypes {
        debug {
            applicationIdSuffix ".debug"
            versionNameSuffix ".d.5"
        }

        release {
        minifyEnabled false
            proguardFiles getDefaultProguardFile('proguard-android.txt'), 'proguard-rules.pro'
        }
    }

    flavorDimensions "server"

    productFlavors {
        prod {
            applicationId "com.tfwm.lighting"
            dimension "server"

            buildConfigField "String", "SERVER_HOST", "\"http://www.crescit.com\""
        }

        dev {
            applicationId "dev.tfwm.lighting"
            versionNameSuffix ".dev"
            dimension "server"

            buildConfigField "String", "SERVER_HOST", "\"http://192.168.60.120\""
        }
    }
}

dependencies {
    implementation fileTree(include: ['*.jar'], dir: 'libs')
    androidTestImplementation('com.android.support.test.espresso:espresso-core:2.2.2', {
        exclude group: 'com.android.support', module: 'support-annotations'
    })
    implementation('com.crashlytics.sdk.android:crashlytics:2.7.1@aar') {
        transitive = true
    }

    implementation "org.jetbrains.kotlin:kotlin-stdlib-jdk7:$kotlin_version"

    implementation 'com.github.sparklit:adbutler-android-sdk:1.0'
    implementation 'com.j256.ormlite:ormlite-core:5.0'
    implementation 'com.j256.ormlite:ormlite-android:5.0'
    implementation 'com.squareup.okhttp:okhttp:2.4.0'
    implementation 'com.android.support:appcompat-v7:28.0.0'
    implementation 'com.android.support:cardview-v7:28.0.0'
    implementation 'com.android.support:recyclerview-v7:28.0.0'
    implementation 'com.android.support:design:28.0.0'
    implementation 'com.android.support:support-vector-drawable:28.0.0'
    implementation 'com.android.support.constraint:constraint-layout:1.1.3'
    implementation 'com.android.support:support-v4:28.0.0'
    implementation 'com.google.android.gms:play-services-location:16.0.0'
    implementation 'com.google.firebase:firebase-core:16.0.7'
    implementation 'com.facebook.fresco:fresco:1.9.0'
    implementation 'com.jakewharton.timber:timber:4.7.0'
    implementation 'com.google.android.gms:play-services-maps:16.1.0'
    testImplementation 'junit:junit:4.12'
    def nav_version = "1.0.0-alpha09"
    implementation "android.arch.navigation:navigation-fragment:$nav_version"
    // use -ktx for Kotlin
    implementation "android.arch.navigation:navigation-ui:$nav_version"
    // use -ktx for Kotlin

    implementation 'pub.devrel:easypermissions:1.1.1'
    implementation 'devlight.io:navigationtabbar:1.2.5'
}

apply plugin: 'com.google.gms.google-services'

repositories {
    mavenCentral()
}