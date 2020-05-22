plugins {
    id 'application'
    id 'org.openjfx.javafxplugin' version '0.0.8'
    id 'org.beryx.jlink' version '2.12.0'
}

group 'me.project.desktop'
version '1.0-SNAPSHOT'

sourceCompatibility = 1.8

repositories {
    mavenCentral()
}

dependencies {
    compile group: 'uk.co.caprica', name: 'vlcj', version: '4.2.0'
    compile group: 'com.fasterxml.jackson.core', name: 'jackson-databind', version: '2.0.1'
    compile group: 'com.google.http-client', name: 'google-http-client', version: '1.23.0'
    compile group: 'com.jfoenix', name: 'jfoenix', version: '8.0.9'
    compile group: 'org.slf4j', name: 'slf4j-simple', version: '1.7.28'
}

javafx {
    version = "13"
    modules = [ 'javafx.controls', 'javafx.fxml', 'javafx.base', 'javafx.graphics', 'javafx.media' ]
}

mainClassName = "me.project.mosaic.Main"

jlink {
    options = ['--strip-debug', '--compress', '2', '--no-header-files', '--no-man-pages']
    launcher {
        name = 'mosaico-desktop'
    }
}