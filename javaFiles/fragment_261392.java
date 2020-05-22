task downloadSources << {
    ...
}

compileJava {
    dependsOn downloadSources
}