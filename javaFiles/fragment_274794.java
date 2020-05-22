task copyDependenciesToTarget(type: Copy) {
    println 'Copying dependencies to target...'

    configurations.compile.collect().each { compileDependency ->
        copy {
            with from (compileDependency.getPath()) {
                include '*'
            }
            into 'target/libs/libs'
        }
    }
}

build.dependsOn(copyDependenciesToTarget)


jar {
    manifest.attributes(
            "Main-Class": "Main",
            "Class-Path": configurations.compile.collect { 'libs/' + it.getName()}.join(' ')
    )
}