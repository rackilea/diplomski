test {
  doFirst {
    def cp = CollectionUtils.join(File.pathSeparator, classpath.getFiles())
    environment 'CLASSPATH', cp
    classpath = classpath.filter { false }
  }
}