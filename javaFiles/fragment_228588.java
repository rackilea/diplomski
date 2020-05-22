configurations {
  sshAntTask
}

dependencies {
  sshAntTask fileTree(dir:'buildSrc/lib', include:'jsch*.jar')
  sshAntTask fileTree(dir:'buildSrc/lib', include:'ant-jsch*.jar')
}

ant.taskdef(
  name: 'scp',
  classname: 'org.apache.tools.ant.taskdefs.optional.ssh.Scp',
  classpath: configurations.sshAntTask.asPath)

task uploadDbServer() {
  doLast  {
    ant.scp(
      file: '...',
      todir: '...',
      keyfile: '...' )
  }
}