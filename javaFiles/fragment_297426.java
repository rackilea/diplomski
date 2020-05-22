allprojects {

    plugins.withType(JavaPlugin) {
        // All the stuff that all Java sub-projects have in common
        // ...
    }
    plugins.withId("org.jetbrains.kotlin.jvm") {
        // All the stuff that all Kotlin sub-projects have in common
        // ...
    }    
}