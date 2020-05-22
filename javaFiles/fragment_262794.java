packagingOptions {
        exclude 'META-INF/DEPENDENCIES'
        exclude 'META-INF/LICENSE'
        exclude 'META-INF/LICENSE.txt'
        exclude 'META-INF/license.txt'
        exclude 'META-INF/NOTICE'
        exclude 'META-INF/NOTICE.txt'
        exclude 'META-INF/notice.txt'
    }

defaultConfig {
        applicationId "your package name here"
        minSdkVersion 15
        targetSdkVersion 23
        versionCode 1
        versionName "1.0"
        multiDexEnabled true
    }