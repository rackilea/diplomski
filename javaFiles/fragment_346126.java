plugins {
    id 'org.openjfx.javafxplugin' version '0.0.5'
    id 'org.beryx.jlink' version '2.3.0'
}

repositories {
    mavenCentral()
}

dependencies {
}

javafx {
    modules = [ 'javafx.controls' ]
}

mainClassName = 'hellofx/hellofx.HelloFX'