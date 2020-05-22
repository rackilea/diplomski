task copySubprojectLibsA (type: Copy, dependsOn: subprojects.jar) {
    from subprojects.jar 
    into 'build/libs/lib'
}

task copySubprojectLibsB (type: Copy, dependsOn: subprojects.jar) {
    from 'src/main/resources'
    into 'build/libs/nosr/conf'
}

task copySubprojectLibs(dependsOn: ["copySubprojectLibsA","copySubprojectLibsB"])