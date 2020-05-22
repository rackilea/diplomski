apply plugin: 'java'

task finalize << {
    println('Here use the copyTask to copy the jar to a specific directory after each build of your library module')
}

build.finalizedBy(finalize)
// compileJava.finalizedBy(copyJarToAndroid) <-- In your case