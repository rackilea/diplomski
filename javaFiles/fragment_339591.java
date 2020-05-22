sourceSets {
    main {
        output.dir("$trashDir", builtBy: 'unzipFile')
    }
}

task unzipFile(type: Copy) {
    dependsOn mkdirTrash
    dependsOn downloadFile
    from zipTree(file("$trashDir/file.zip"))
    into trashDir
    outputs.dir sourceSets.main.output.resourcesDir
}