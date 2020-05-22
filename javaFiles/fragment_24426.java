android {
    compileSdkVersion 22
    buildToolsVersion "23.0.0"

         defaultConfig {
             minSdkVersion 14 //lower than 14 doesn't support multidex
             targetSdkVersion 22

             // Enabling multidex support.
             multiDexEnabled true
         }
}

dependencies {
    //need to add multidex dependency 
    compile 'com.android.support:multidex:1.0.1'
}