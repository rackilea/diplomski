task copyToLib( type: Copy ) {
    into "$buildDir/myapp/lib"
    from configurations.runtime {
        exclude group: 'org.slf4j'
    }

    // We only want jars files to go in lib folder
    exclude "*.exe"
    exclude "*.bat"
    exclude "*.cmd"
    exclude "*.dll"

}