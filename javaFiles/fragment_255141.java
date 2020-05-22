apply plugin: 'com.android.application'

android {
    compileSdkVersion 24
    buildToolsVersion "24.0.1"
    defaultConfig {
        applicationId "com.gujrat.quiz.qrcodereader"
        minSdkVersion 16
        targetSdkVersion 24
        versionCode 1
        versionName "1.0"
        testInstrumentationRunner "android.support.test.runner.AndroidJUnitRunner"
    }
    buildTypes {
        release {
            minifyEnabled false
            proguardFiles getDefaultProguardFile('proguard-android.txt'), 'proguard-rules.pro'
        }
    }
}

repositories {
    mavenCentral()
    maven { url "https://oss.sonatype.org/content/repositories/snapshots/" }
}

dependencies {
    compile fileTree(dir: 'libs', include: ['*.jar'])
    androidTestCompile('com.android.support.test.espresso:espresso-core:2.2.2', {
        exclude group: 'com.android.support', module: 'support-annotations'
    })
    compile 'com.android.support:appcompat-v7:24.1.1'
    compile 'com.android.support.constraint:constraint-layout:1.0.0-alpha5'
    compile 'me.dm7.barcodescanner:zxing:1.8.4'
    compile 'cn.pedant.sweetalert:library:1.3'
    compile 'com.michaelpardo:activeandroid:3.1.0-SNAPSHOT'
    compile 'com.android.support:recyclerview-v7:24.0.+'
    testCompile 'junit:junit:4.12'
}