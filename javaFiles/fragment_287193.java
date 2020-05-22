task cucumber(type: JavaExec) {
    dependsOn assemble, compileTestJava
    main = "cucumber.api.cli.Main"
    classpath = configurations.cucumberRuntime + sourceSets.main.output + sourceSets.test.output
    args = ['-f', 'pretty', '--glue', 'steps', 'src/test/resources']
    systemProperties = System.getProperties()
}