configurations.all {
    resolutionStrategy {
        dependencySubstitution {
            substitute module('org.codehaus.groovy:groovy:2.4.7') with module('org.codehaus.groovy:groovy:2.4.12')
        }
    }
}