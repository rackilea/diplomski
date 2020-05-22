android {
    …
    buildTypes {
        release {
            minifyEnabled true
            consumerProguardFiles 'proguard-rules.txt'
        }
    }
}