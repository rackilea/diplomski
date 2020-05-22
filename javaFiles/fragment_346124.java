plugins {
    id 'application'
    id 'org.openjfx.javafxplugin' version '0.0.5'
}

repositories {
    mavenCentral()
}

dependencies {
}

javafx {
    modules = [ 'javafx.controls' ]
}

mainClassName = 'hellofx.HelloFX'

jar {
    manifest {
        attributes 'Main-Class': 'hellofx.Launcher'
    }
    from {
        configurations.compile.collect { it.isDirectory() ? it : zipTree(it) }
    }
}