android{
    defaultConfig {
            applicationId "com.deerwalk.healthportal"
            minSdkVersion 15
            targetSdkVersion 23
            versionCode 1
            versionName "1.0"
        }
        buildTypes {
            release {
                minifyEnabled false
                proguardFiles getDefaultProguardFile('proguard-android.txt'), 'proguard-rules.pro'
            }
        }
            productFlavors {
                    deerwalk {
                        applicationId
                        "com.abc.xyz"
                        versionName "1.0"
                    }
                    sdemo {
                        applicationId
                        "com.abc.xyz"
                        versionName "1.0"
                    }
                    tdemo {
                        applicationId
                        "com.abc.xyz"
                        versionName "1.0"
                    }
                } }