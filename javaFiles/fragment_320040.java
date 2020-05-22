task copyDeps(type: Sync) {
    configurations.myDeps.resolvedConfiguration.resolvedArtifacts.each {
        def id = it.moduleVersion.id
        def groupFolders = id.group.replaceAll(/\./, "/")
        from(it.file) {
            into "$groupFolders/${id.name}/${id.version}/"
        }
        into "$buildDir/copyLocation"
    }
}