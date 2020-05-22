android {
    ...
    buildTypes {
        release {
            minifyEnabled true
            proguardFiles 'proguard-rules.txt', getDefaultProguardFile('proguard-android.txt')
        }
    }
}