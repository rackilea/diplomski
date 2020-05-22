plugins {
    id 'org.openjfx.javafxplugin' version '0.0.5'
    id 'org.beryx.runtime' version '1.0.0'
    id "com.github.johnrengelman.shadow" version "4.0.3"
}

repositories {
    mavenCentral()
}

dependencies {
}

javafx {
    modules = [ 'javafx.controls' ]
}

mainClassName = 'hellofx.Launcher'

runtime {
    options = ['--strip-debug', '--compress', '2', '--no-header-files', '--no-man-pages']
}