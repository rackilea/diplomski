task copyFiles(type: Copy) {
    description = 'Copying the jar'
    from 'your/jar/directory'
    into project(':Path:To:ModuleFrom:Settings.gradle').file('./libs')
    include 'jar-from-dependency.jar'
}

project.afterEvaluate {
    preBuild.dependsOn copyFiles
}

clean.dependsOn copyFiles
clean.mustRunAfter copyFiles