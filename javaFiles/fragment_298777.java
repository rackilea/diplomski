ext.execPath = "$System.env.PATH" + System.getProperty("path.separator") + "$projectDir/src/dist/util"

task taskA(type: Exec){
    environment "PATH", execPath
    ...
}

task taskB(type: Exec){
    environment "PATH", execPath
    ...
}