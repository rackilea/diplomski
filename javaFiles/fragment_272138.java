ant.importBuild('buildA.xml') { antTargetName ->
    'a-' + antTargetName
}

ant.importBuild('buildB.xml') { antTargetName ->
    'b-' + antTargetName
}