task runHelloWorld(type: Exec) {
    commandLine 'java', '-Djava.library.path=lib', '-jar', 'lib/avatar-js.jar', 'helloWorld.js'
}

task runHelloWorld2(type: JavaExec) {
    args 'helloWorld.js'
    main 'com.oracle.avatar.js.Server'
    systemProperties 'java.library.path':'lib'
    classpath 'lib/avatar-js.jar'
}