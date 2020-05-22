test {
    doFirst {
        jvmArgs += [
                '--add-exports', "module/package=junit",
        ]
    }
}