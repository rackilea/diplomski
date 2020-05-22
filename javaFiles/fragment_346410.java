apply plugin: 'java'

buildscript {
    tasks.withType(JavaCompile) {
        sourceCompatibility = JavaVersion.VERSION_1_7
        targetCompatibility = JavaVersion.VERSION_1_7
    }
}

dependencies {
    compile fileTree(include: ['*.jar'], dir: 'libs')

    // Your libraries here

}