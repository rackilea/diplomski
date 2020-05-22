configurations {
    remoteSources {
        transitive false
    }
}

dependencies {
    remoteSources 'com.github.jsimone:webapp-runner:7.0.22'
}

task copyRemoteSources(type: Copy) {
    from configurations.remoteSources
    into "${project.buildDir}/remoteSources"
}