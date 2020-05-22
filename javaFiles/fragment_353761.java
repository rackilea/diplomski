android {
   compileSdkVersion 26
   buildToolsVersion "21.1.2"

   defaultConfig {
      ...
      minSdkVersion 15
      targetSdkVersion 21
      ...

      // Enabling multidex support.
      multiDexEnabled true
   }
   ...
}

dependencies {
   compile 'com.android.support:multidex:1.0.1'    <-- Not required when minimum sdk is >=21
}