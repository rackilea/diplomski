apply plugin: 'java'

repositories { ... }

dependencies {
    compile 'foo:bar:1.0'
    runtime 'foo:baz:1.0'
}

task download {
    inputs.files configurations.runtime
    outputs.dir "${buildDir}/download"
    doLast {
        def componentIds = configurations.runtime.incoming.resolutionResult.allDependencies.collect { it.selected.id }
        ArtifactResolutionResult result = dependencies.createArtifactResolutionQuery()
            .forComponents(componentIds)
            .withArtifacts(JvmLibrary, SourcesArtifact)
            .execute()
        def sourceArtifacts = []
        result.resolvedComponents.each { ComponentArtifactsResult component ->
            Set<ArtifactResult> sources = component.getArtifacts(SourcesArtifact)
            println "Found ${sources.size()} sources for ${component.id}"
            sources.each { ArtifactResult ar ->
                if (ar instanceof ResolvedArtifactResult) {
                    sourceArtifacts << ar.file
                }
            }
        }

        copy {
            from configurations.runtime
            from sourceArtifacts
            into "${buildDir}/download"
        }
    }
}