pluginManagement {
    repositories {
        maven { url ".../nexus/content/groups/GradlePlugins/" }
        maven { url ".../nexus/content/groups/public/" }
    }
    resolutionStrategy {
        eachPlugin {
            if (requested.id.namespace == 'org.jsonschema2pojo') {
                useModule("org.jsonschema2pojo:jsonschema2pojo-gradle-plugin:$requested.version")
            }
        }
    }
}