import com.github.jengelman.gradle.plugins.shadow.transformers.AppendingTransformer

shadowJar {
    mergeServiceFiles()
    transform(AppendingTransformer) { resource = 'META-INF/spring.handlers' }
    transform(AppendingTransformer) { resource = 'META-INF/spring.schemas' }

    manifest {
        attributes 'Main-Class': 'com.company.MainRunner'
    }
    from sourceSets.test.output.classesDirs

    configurations = [project.configurations.testRuntime]
}