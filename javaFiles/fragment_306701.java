subprojects {
    apply plugin: 'io.spring.dependency-management'

    dependencyManagement {
        applyMavenExclusions false
    }

    ext['spring-hateoas.version'] = "$springHateoasVersion"
}