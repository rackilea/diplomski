task buildTextures(type: JavaExec) {
    inputs.dir 'textures/dir'
    outputs.dir "$buildDir/textures"

    jvmArgs '-jar', 'somejar.jar'
    args // arguments to executable jar main class
}

assemble.dependsOn buildTextures