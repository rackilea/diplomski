task datanucleusEnhance {
  description "Enhance JDO model classes using DataNucleus Enhancer"
  dependsOn compileJava

  doLast {    
      // define the entity classes
      def entityFiles = fileTree(sourceSets.main.output.classesDir).matching {
          include 'com/mycom/*.class', 'org/myorg/*.class'
      }

      println "Enhancing with DataNucleus the following files"
      entityFiles.getFiles().each {
          println it
      }

      // define Ant task for DataNucleus Enhancer
      ant.taskdef(
          name : 'datanucleusenhancer',
          classpath : sourceSets.main.runtimeClasspath.asPath,
          classname : 'org.datanucleus.enhancer.EnhancerTask'
          // the below is for DataNucleus Enhancer 3.1.1
          //classname : 'org.datanucleus.enhancer.tools.EnhancerTask'
      )

      // run the DataNucleus Enhancer as an Ant task
      ant.datanucleusenhancer(
          classpath: sourceSets.main.runtimeClasspath.asPath,
          verbose: true,
          api: "JDO") {
          entityFiles.addToAntBuilder(ant, 'fileset', FileCollection.AntType.FileSet)
      }
  }
}

classes.dependsOn(datanucleusEnhance)