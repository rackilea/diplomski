apply plugin: 'com.android.application'

android {
    compileSdkVersion 26
    buildToolsVersion "26.0.3"
    defaultConfig {
        applicationId "gluonhq.com.myfragment"
        minSdkVersion 25
        targetSdkVersion 26
        versionCode 1
        versionName "1.0"
        multiDexEnabled true
        testInstrumentationRunner "android.support.test.runner.AndroidJUnitRunner"
    }
    dexOptions {
        preDexLibraries = false
        additionalParameters=['--core-library']
    }
    buildTypes {
        release {
            minifyEnabled false
            proguardFiles getDefaultProguardFile('proguard-android.txt'), 'proguard-rules.pro'
        }
    }
    sourceSets {
        main {
            jniLibs.srcDir file("$dalvikPath/rt/lib")
            assets.srcDirs = ['assets']
        }
    }
    lintOptions {
        abortOnError false
    }
}

dependencies {
    compile fileTree(dir: 'libs', include: ['*.jar'])
    compile fileTree(include: ['*.jar'], dir: '$dalvikPath/rt/lib/ext')
    androidTestCompile('com.android.support.test.espresso:espresso-core:2.2.2', {
        exclude group: 'com.android.support', module: 'support-annotations'
    })
    compile 'com.android.support:multidex:1.0.1'
    compile 'com.android.support:appcompat-v7:26.0.0-alpha1'
    compile 'com.android.support:design:26.0.0-alpha1'
    testCompile 'junit:junit:4.12'
}