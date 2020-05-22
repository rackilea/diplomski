//
// Command line: gradle war -Production
//
boolean production = hasProperty("roduction");

//
// Import java regex
//
import java.util.regex.*

//
// Change Config.java DEBUG value based on the build type
//
String filterDebugHelper(String line) {
  Pattern pattern = Pattern.compile("(boolean\\s+DEBUG\\s*=\\s*)(true|false)(\\s*;)");
  Matcher matcher = pattern.matcher(line);
  if (matcher.find()) {
    line = matcher.replaceFirst("\$1"+(production? "false": "true")+"\$3");
  }

  return (line);
}

//
// Filter Config.java and inizialize 'DEBUG' according to the current build type
//
task filterDebug(type: Copy) {
  from ("${projectDir}/src/main/java/com/company/project") {
    include "Config.java"

    filter { String line -> filterDebugHelper(line) }
  }
  into "${buildDir}/tmp/filterJava"
}

//
// Remove from compilation the original Config.java and add the filtered one
//
sourceSets {
  main {
    java {
      srcDirs ("${projectDir}/src/main/java", "${buildDir}/tmp/filterJava")
      exclude ("com/company/project/Config.java")
    }

    resources {
    }
  }
}

//
// Execute 'filterDebug' task before compiling 
//
compileJava {
  dependsOn filterDebug
}