sourceSets {
    generated.java {
        srcDir file('/build/generated/java')
    }
}

dependencies {
    compile("com.querydsl:querydsl-jpa:${queryDslVersion}")
    compile "org.hibernate.javax.persistence:hibernate-jpa-2.1-api:${hibernateJpaVersion}"

    annotationProcessor "com.querydsl:querydsl-apt:${queryDslVersion}:jpa"
    annotationProcessor "org.hibernate.javax.persistence:hibernate-jpa-2.1-api:${hibernateJpaVersion}"
}
compileJava {
    options.annotationProcessorPath = configurations.annotationProcessor
    options.setAnnotationProcessorGeneratedSourcesDirectory(file("$projectDir/build/generated/java"))
}