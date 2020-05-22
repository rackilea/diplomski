apply plugin: 'eclipse'

eclipse.classpath.file {
  withXml {
    xml ->
    def node = xml.asNode()
    node.classpathentry.forEach {
      if(it.@kind == 'lib') {
        def sourcePath = it.@path.replace('.jar', '-sources.jar')
        if(file(sourcePath).exists()) {
          it.@sourcepath = sourcePath
        }
      }
    }
  }
}