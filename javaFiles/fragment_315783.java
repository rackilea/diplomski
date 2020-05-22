apply plugin: 'com.android.application'

android {
    compileSdkVersion 26
    buildToolsVersion '27.0.1'

    defaultConfig {
        applicationId "com.micropeda.sudoku"
        minSdkVersion 15
        targetSdkVersion 26
        versionCode 20171216
        versionName "2.4.1"
    }


 buildTypes {
      release {
            minifyEnabled true
            shrinkResources true
            proguardFiles getDefaultProguardFile('proguard-android.txt'), 'proguard-rules.pro'
        }
    }

}

dependencies {
    implementation 'com.google.android.gms:play-services-ads:11.6.2'
    compile fileTree(dir: 'libs', include: ['*.jar'])
    //noinspection GradleCompatible
    compile 'com.android.support:appcompat-v7:22.1.1'
    compile 'com.google.android.instantapps:instantapps:1.1.0'
}