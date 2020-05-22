apply plugin: 'com.neenbedankt.android-apt'

 dependencies {
    // apt command comes from the android-apt plugin
   apt 'com.google.dagger:dagger-compiler:2.2'
   compile 'com.google.dagger:dagger:2.2'
   provided 'javax.annotation:jsr250-api:1.0'
 }