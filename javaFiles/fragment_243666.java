sourceCompatibility = '11'

dependencies {
    implementation 'org.springframework.boot:spring-boot-starter-webflux'
    testImplementation 'org.springframework.boot:spring-boot-starter-test'

    // Java 11 removed these Java EE modules
    implementation "javax.xml.bind:jaxb-api:2.3.1"
    implementation "com.sun.xml.bind:jaxb-core:2.3.0.1"
    implementation "com.sun.xml.bind:jaxb-impl:2.3.2"

    compileOnly "org.projectlombok:lombok"
    annotationProcessor "org.projectlombok:lombok"
}