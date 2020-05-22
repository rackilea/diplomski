shadowJar {
    zip64 true
    entryCompression = org.gradle.api.tasks.bundling.ZipEntryCompression.STORED
    exclude 'META-INF/*.RSA', 'META-INF/*.SF','META-INF/*.DSA'
    manifest {
        attributes 'Main-Class': 'com.my.project.Main'
    }
}