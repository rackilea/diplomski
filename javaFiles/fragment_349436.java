android {
    compileSdkVersion 23
    buildToolsVersion "23.0.2"

    defaultConfig {
        ...
        minSdkVersion 19
        targetSdkVersion 23
        ...

        // Enabling multidex support.
        multiDexEnabled true
    }
    ...
}

dependencies {
  compile 'com.android.support:multidex:1.0.1'
}