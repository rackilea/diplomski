buildscript {
    repositories {
        mavenCentral()
        maven {
            url "https://oss.sonatype.org/content/repositories/snapshots/"
        }
        jcenter()
    }
    dependencies {
        classpath 'de.richsource.gradle.plugins:gwt-gradle-plugin:0.6'
        classpath 'com.android.tools.build:gradle:2.2.3'
        classpath 'org.robovm:robovm-gradle-plugin:1.14.0'
    }
}