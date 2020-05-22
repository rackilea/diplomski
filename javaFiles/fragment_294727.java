allprojects { project ->
    project.plugins.withId('java') {
        test {
            maxHeapSize = "1536M"
            // If you don't want to use spring.properties (or add other JVM args)
            jvmArgs "-Dspring.test.context.cache.maxSize=1"
        }
    }
    project.plugins.withId('java-library') {
        test {
            maxHeapSize = "1536M"
            // If you don't want to use spring.properties (or add other JVM args)
            jvmArgs "-Dspring.test.context.cache.maxSize=1"
        }
    }
}