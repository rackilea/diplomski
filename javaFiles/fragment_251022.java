configurations {
    apt
}

dependencies {
    apt 'org.jooq: jooq-checker:3.10.5'
}

tasks.withType(JavaCompile) {
    options.annotationProcessorPath = configurations.apt
    options.compilerArgs << "-processor" << "org.jooq.checker.SQLDialectChecker"
}