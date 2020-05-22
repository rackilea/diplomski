repositories {
    mavenCentral() //or jcenter()
}
configurations {
    closureCompiler
}
dependencies {
    closureCompiler 'com.google.javascript:closure-compiler:v20150609'
}

task compileJS(type: JavaExec){
    classpath configurations.closureCompiler
    main = 'com.google.javascript.jscomp.CommandLineRunner'

    def closureArgs = []
    //append all your command line options here
    closureArgs << "--compilation_level=SIMPLE_OPTIMIZATIONS"
    closureArgs << "--js_output_file=app.js"
    closureArgs << "input1.js"
    closureArgs << "input2.js"
    closureArgs << "src/**.js"

    args closureArgs
}