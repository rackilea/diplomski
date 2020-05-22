configurations {
    hibernateAnnotationProcessor
}

dependencies {
    hibernateAnnotationProcessor "org.hibernate: ..."
}

compileJava.compileClasspath += configurations.hibernateAnnotationProcessor