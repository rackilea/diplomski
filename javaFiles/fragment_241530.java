ospackage {
  packageName = 'project'

  configurationFile "/opt/project/bin/project.service"

  into '/opt/project'

  from(jar.outputs.files) {
    into 'lib'
  }
  from(configurations.runtime) {
    into 'lib'
  }
  from('build/libs') {
    into 'lib'
  }
  from('conf'){
    into 'conf'
  }
  from('bin') {                      //project.service is in bin directory
    fileType = CONFIG | NOREPLACE    //wont replace any configurationFile in this directory
    into 'bin'
  }
  from('build/scripts') {
    into 'bin'
    exclude 'database'
    fileMode = 0550
  }
}