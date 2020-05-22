apply plugin: 'java'

task(runSimple, dependsOn: 'classes', type: JavaExec) {
   main = 'com.mrhaki.java.Simple'
   classpath = sourceSets.main.runtimeClasspath
   args 'mrhaki'
   systemProperty 'simple.message', 'Hello '
}