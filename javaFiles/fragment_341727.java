android {
    compileSdkVersion 21
    buildToolsVersion '21.1.2'

    defaultConfig {
        applicationId "com.elgami.customizer"
        minSdkVersion 14
        targetSdkVersion 21
    }

    buildTypes {
        release {
            minifyEnabled false
            //runProguard false
            //proguardFiles getDefaultProguardFile('proguard-android.txt'), 'proguard-rules.txt'
        }
    }
}