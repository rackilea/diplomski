metaInf {
    from(zipTree(configurations.yourConfiguration.singleFile)) {
        include 'jquery-min.js'
        into 'resources/foo/bar/'
    }
}