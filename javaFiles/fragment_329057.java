android {
compileSdkVersion 26
buildToolsVersion "26.0.2"
defaultConfig {
    applicationId "com.example.bmeccoffice.remotehelp"
    minSdkVersion 22
    targetSdkVersion 22
    versionCode 1
    versionName "1.0"
    testInstrumentationRunner "android.support.test.runner.AndroidJUnitRunner"
    jackOptions {
        enabled true
    }
}
buildTypes {
    release {
        minifyEnabled false
        proguardFiles getDefaultProguardFile('proguard-android.txt'), 'proguard-rules.pro'
    }
}


compileOptions {
    sourceCompatibility JavaVersion.VERSION_1_8
    targetCompatibility JavaVersion.VERSION_1_8
    incremental false
}
}