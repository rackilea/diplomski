apply plugin: "idea"
apply plugin: "java"

repositories {
    mavenCentral()
}

dependencies {
    compile "com.intellij:forms_rt:7.0.3"
    runtime "com.intellij:forms_rt:7.0.3"
}

def jarPackage(artifactName, artifactVersion) {
    if (artifactVersion == "" || artifactVersion == null) {
        artifactVersion = "1.0.0"
    }
    return tasks.create("jar${artifactName}", Jar) {
        baseName = artifactName
        version = artifactVersion
        String className = baseName.capitalize()

        from(sourceSets.main.output) {
            include "$baseName/**"
        }

        from {
            configurations.compile.collect {
                it.isDirectory() ? it : zipTree(it)
            }
        }

        manifest {
            attributes "Implementation-Title": "$className",
                    "Implementation-Version": "$version",
                    "Main-Class": "$baseName.$className"
        }
    }
}

artifacts {
    archives jarPackage("aleatoire", ""), jarPackage("calculatrice", "1.2.3"), jarPackage("copier", ""),
            jarPackage("qcm", "1.0.0")
}