preBuild {
    doFirst {
        JavaCompile jc = android.applicationVariants.find { it.name == 'debug' }.javaCompile
        jc.options.compilerArgs = ["-Xlint:unchecked"]
    }
}