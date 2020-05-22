android {
    compileSdkVersion 22
    buildToolsVersion '22.0.1'

    dexOptions {
        preDexLibraries = false
        javaMaxHeapSize "2g"
    }
    defaultConfig {
        ...
        multiDexEnabled = false
    }
    lintOptions {
        abortOnError false
        disable 'InvalidPackage'
    }

    ...
}


dependencies {
    compile 'com.android.support:appcompat-v7:22.1.1' // Do NOT use 22.2.0 even it is newer one. It reported to cause some problems with other dependencies.
    compile fileTree(dir: 'libs', include: '*.jar')
    compile('com.google.android.gms:play-services-gcm:7.5.+')
        {
            exclude module: 'support-v4'
        }
}