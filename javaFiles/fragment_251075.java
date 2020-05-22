plugins {
    id "com.github.onslip.gradle-one-jar" version "1.0.5"
}

task awesomeFunJar(type: OneJar) {
    mainClass = 'com.github.rholder.awesome.MyAwesomeMain'
}