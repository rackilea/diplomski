apply plugin: 'com.android.application'

android {
    ...

    defaultConfig {
        ...

        testInstrumentationRunner "android.support.test.runner.AndroidJUnitRunner"
    }
}

dependencies {
    // App's dependencies, including test
    compile 'com.android.support:support-annotations:23.0.1'

    ...
}