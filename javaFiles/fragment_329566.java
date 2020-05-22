task usefulStuff(type: JavaExec) {
      classpath = sourceSets.main.runtimeClasspath
      main = 'com.me.gradle.UsefulStuff'
      // arguments to pass to the application
      args 'OhmyGod!'
    }