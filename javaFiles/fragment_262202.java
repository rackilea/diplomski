buildscript {
    repositories {
        jcenter()
        maven { url = "https://files.minecraftforge.net/maven" }
    }
    dependencies {
        classpath 'net.minecraftforge.gradle:ForgeGradle:2.3-SNAPSHOT'
    }
}
apply plugin: 'net.minecraftforge.gradle.forge'