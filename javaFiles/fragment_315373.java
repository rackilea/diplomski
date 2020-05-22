task bundleBin << {
    task bundleBin_childTask(type: Zip) {
        def bundleName = "$outputName-bin"
        def deps = configurations.runtime.getAllDependencies().findAll { it instanceof ProjectDependency }

        into(bundleName) {
            for (dep in deps) {
                def proj = dep.getDependencyProject()
                from (proj.projectDir) {
                    include "conf/"
                    include "scripts/"
                }
            }
        }

        into(bundleName) {
            from(".") {
                include "conf/"
                include "scripts/"
            }
        }

        into("$bundleName/lib") {
            from configurations.runtime.allArtifacts.files
            from configurations.runtime
        }

        archiveName = "${bundleName}.zip"
    }

    bundleBin_childTask.execute()
}