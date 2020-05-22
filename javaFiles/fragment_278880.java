apply plugin: 'war'

repositories {
   mavenCentral()
}

tasks.addRule("Pattern: buildWar<ENV>") { String taskName ->
    if (taskName.startsWith('buildWar')) {
        def env = (taskName - 'buildWar').toLowerCase()
        if (env in ['dev', 'prod',]) {
          task(taskName, type: War) {
              println "Configuring env: $env"
              from("src/main/conf/$env") {
                  into("conf")
              }
          }
        } else {
          println "Invalid env: $env, skipping."
        }
    }
}