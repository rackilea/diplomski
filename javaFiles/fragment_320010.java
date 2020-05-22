buildTypes {

release {
    minifyEnabled true
    proguardFiles getDefaultProguardFile('proguard-android.txt'), 
    'proguard-rules.pro'
    multiDexEnabled false
}