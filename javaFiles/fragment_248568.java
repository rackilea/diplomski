apply plugin: 'com.android.application'

android {
    compileSdkVersion 21
    buildToolsVersion "21.1.1"

    defaultConfig {
        applicationId "br.com.acs.app"
        minSdkVersion 18
        targetSdkVersion 21
        versionCode 1
        versionName "1.0"
        testApplicationId "br.com.acs.app.test"
        testInstrumentationRunner "android.support.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            minifyEnabled false
            proguardFiles getDefaultProguardFile('proguard-android.txt'), 'proguard-rules.pro'
        }
        debug {
            testCoverageEnabled true
        }
    }

    packagingOptions {
        exclude 'LICENSE.txt'
    }
}

dependencies {
    compile fileTree(dir: 'libs', include: ['*.jar'])
    compile 'com.android.support:appcompat-v7:21.0.3'

    androidTestCompile 'junit:junit:4.11'
    androidTestCompile('com.android.support.test:testing-support-lib:0.1') {
        exclude group: 'junit' 
    }
}