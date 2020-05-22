buildscript {
    repositories {
        mavenCentral()
        google()
    }
    dependencies {
        classpath 'com.android.tools.build:gradle:3.1.2'
    }
}
apply plugin: 'com.android.application'

repositories {
    mavenCentral()
}

android {
    compileSdkVersion 27
    defaultConfig {
        minSdkVersion 17
        targetSdkVersion 27
        versionCode 1
        versionName "1.0"
        testInstrumentationRunner "android.support.test.runner.AndroidJUnitRunner"

    }
    buildTypes {
        release {
            proguardFile getDefaultProguardFile('proguard-android.txt')
        }
    }
    productFlavors {
        defaultFlavor {
            proguardFile 'proguard-rules.txt'
        }
    }
    flavorDimensions "default"
}
allprojects {
    repositories {
        maven { url "https://jitpack.io" }
    }
}
dependencies {
    implementation 'com.android.support:design:27.1.1'
    implementation 'com.android.support.constraint:constraint-layout:1.1.0'
    implementation 'com.android.support:cardview-v7:27.1.1'
    implementation 'com.android.support:recyclerview-v7:27.1.1'
    implementation 'com.android.support:appcompat-v7:27.1.1'

    implementation 'com.squareup.picasso:picasso:2.5.2'
    implementation 'com.google.apis:google-api-services-youtube:v3-rev182-1.22.0'
    implementation 'com.google.http-client:google-http-client-android:1.20.0'
    implementation 'com.google.api-client:google-api-client-android:1.20.0'
    implementation 'com.google.api-client:google-api-client-gson:1.20.0'

    implementation 'com.github.PierfrancescoSoffritti:AndroidYouTubePlayer:7.0.0'
}