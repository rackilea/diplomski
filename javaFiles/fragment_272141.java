apply plugin: 'war'

// See http://gradle.org/docs/current/userguide/war_plugin.html
//   Section 26.5. Convention properties
webAppDirName = 'WebContent'

// See http://gradle.org/docs/current/userguide/java_plugin.html
//   Section 23.4.1. Changing the project layout
sourceSets {
    main {
        // where does the Java source code live?
        java {
            srcDir 'Java Resources/src'
        }

        // where do classpath resources like *.properties files live?
        resources {
            srcDir 'Java Resources/src'
        }
    }
}

// See http://gradle.org/docs/current/userguide/dependency_management.html
//   Section 51.4.4. File dependencies
dependencies {
    // Where do the JARs live on the filesystem?
    compile fileTree(dir: "${webAppDirName}/WEB-INF/lib", include: '*.jar')
}