plugins {
    id "net.ltgt.apt" version "0.15"
}
apply plugin: 'java-library'



dependencies {
    implementation fileTree(dir: 'libs', include: ['*.jar'])
    implementation 'com.google.dagger:dagger:2.15'
    apt 'com.google.dagger:dagger-compiler:2.13'
}

sourceCompatibility = "1.8"
targetCompatibility = "1.8"