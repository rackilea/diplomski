repositories {
    mavenCentral()
    jcenter()
    mavenLocal()
    maven {
        name 'maven.aviary.com'
        url uri("http://maven.aviary.com/repo/release")
    }
}

android {
    compileSdkVersion 20
    buildToolsVersion "20.0.0"

    defaultConfig {
        minSdkVersion 10
        targetSdkVersion 20
        versionCode 1
        versionName "1.0"
    }

    buildTypes {
        release {
            minifyEnabled false
            proguardFiles getDefaultProguardFile('proguard-android.txt'), 'proguard-rules.pro'
        }
    }

    compileOptions {
        sourceCompatibility JavaVersion.VERSION_1_7
        targetCompatibility JavaVersion.VERSION_1_7
    }

    packagingOptions {
        exclude 'META-INF/NOTICE.txt'
        exclude 'META-INF/LICENSE.txt'
    }

}

dependencies {
    compile 'com.aviary.android.feather.sdk:aviary-sdk:3.6.3'
}