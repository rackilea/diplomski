configurations.all {
    resolutionStrategy {
        eachDependency {
            if (it.requested.group == 'org.apache.tomcat.embed') {
                it.useVersion '7.0.56'
            }
        }
    }
}