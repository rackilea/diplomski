java {
    sourceSets["main"].java {
        srcDir("generated/src/main/java")
    }

    sourceSets["main"].resources {
        srcDir("generated/src/main/resources")
    }
}