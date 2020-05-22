task run(type: JavaExec) {
    ...
    jvmArgs '-Xss80m' // will add this argument to list
    // or
    jvmArgs = ['-Xss80m'] // will replace arguments list
}