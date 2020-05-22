task copyJarToBin {
    copy {
        from 'build/libs/GradleJarProject.jar'
        into "d:/tmp"
    }
}