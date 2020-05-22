shadowJar {
  manifest {
     attributes 'Implementation-Title': 'rpi-sense-hat-lib',
            'Implementation-Version': version,
            'Main-Class': 'io.github.lunarwatcher.pi.sensehat.Tests'
  }
  configurations = [project.configurations.compile, project.configurations.runtime]
}