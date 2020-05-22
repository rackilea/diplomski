configurations {
    deployerJars
}

dependencies {
    deployerJars group: 'org.n52.matlab', name: 'matlab-control', version: '5.0.0'
}

task copyToLib(type: Copy) {
    into "$buildDir/libs"
    from configurations.deployerJars
}