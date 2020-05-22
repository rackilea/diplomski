buildscript {  
    repositories {
        flatDir { dirs '/proguard' }
    }
    dependencies {
        classpath ':proguard:'
    }
}