plugins {
    id 'org.openjfx.javafxplugin' version '0.0.5'
}

repositories {
    mavenCentral()
}

dependencies {
}

javafx {
    version = "12-ea+5"
    modules = [ 'javafx.controls' ]
}

mainClassName = 'hellofx/hellofx.HelloFX'

def java_home = '/Users/<user>/Downloads/jdk-12.jdk/Contents/Home'
def installer = 'build/installer'
def appName = 'HelloFXApp'

task copyDependencies(type: Copy) {
    dependsOn 'build'
    from configurations.runtime
    into "${buildDir}/libs"
}

task jpackage(type: Exec) {
    dependsOn 'clean'
    dependsOn 'copyDependencies'

    commandLine "${java_home}/bin/jpackage", 'create-installer', "dmg",
            '--output', "${installer}", "--name", "${appName}",
            '--verbose', '--echo-mode', '--module-path', 'build/libs',
            '--add-modules', "${moduleName}", '--input', 'builds/libraries',
            '--class', "${mainClassName}", '--module', "${mainClassName}"
}