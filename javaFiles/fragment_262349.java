jar {
   manifest {
       attributes (
            'Class-Path': configurations.compile.collect {it.getName()}.join(' '),
            'Main-Class': 'com.test.MainClassName'
       )
   }
   from {
    configurations.runtimeClasspath.collect {it.isDirectory() ? it : zipTree(it) }
    }
}