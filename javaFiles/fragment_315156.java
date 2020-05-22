task makeJar(type: Copy) {
    from('directory1/')
    from('directory2/')

    into('another directory/')
    include('classes.jar')
}