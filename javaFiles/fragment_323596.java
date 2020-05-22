subprojects {
   apply plugin: 'java'
}

task copyFiles(type: Copy, dependsOn: subprojects.jar) {
   from(subprojects.jar)
   into project.file('dest')
}