jar {
  manifest {
    from { configurations.compile.collect { it.isDirectory() ? it : zipTree(it) } }
    attributes 'Main-Class': 'de.to.main.class.itv.Main'
  }
}