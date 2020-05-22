allprojects{
    apply plugin: 'java'
    apply plugin: 'groovy'

    // blah blah uncomment if you need.
    //apply plugin: 'pmd'
    //apply plugin: 'findbugs'
    //apply plugin: 'checkstyle'
    //apply plugin: 'jacoco'

    tasks.withType(Compile) {
        options.debug = true
        options.compilerArgs = ["-g"]
    }

    // ..
    // .. more code exists here for commented out lines as shown above, so ignore this in your version
    // .. 

    task myAliasNoTestBuild() << { 
        // see link below on how to create alias tasks
    }
}