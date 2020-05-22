task copyJarToBin {
    doLast {
        copy {
            from 'build/libs/GradleJarProject.jar'
            into "d:/tmp"
        }

    }
}