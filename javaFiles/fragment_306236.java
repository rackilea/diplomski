android {
compileSdkVersion 23
buildToolsVersion "23.0.0"

defaultConfig {

    ...

    multiDexEnabled true
}

    ...

dependencies {
    ...

    compile 'com.android.support:multidex:1.0.0'
}