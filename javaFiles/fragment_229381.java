task run(type: Exec, dependsOn: [copyToLib, war]) {
    def pathClosure = {
        fileTree("$buildDir/server/").include("webapp-runner-*.jar").singleFile
    }
    mustRunAfter copyToLib
    executable 'java'
    args '-jar', pathClosure, war.archivePath, '--port', "$port"
}