buildscript {
    repositories {
        mavenCentral()
        mavenLocal()
        maven { url 'https://github.com/steffenschaefer/gwt-gradle-plugin/raw/maven-repo/' }
    }
    dependencies {
        classpath 'de.richsource.gradle.plugins:gwt-gradle-plugin:0.4'
        classpath 'com.android.tools.build:gradle:0.11+'  // <-- Changing this to 0.11+ fixed it for me.
        classpath 'com.github.jtakakura:gradle-robovm-plugin:0.0.9'
    }
}