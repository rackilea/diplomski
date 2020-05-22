compile group: 'org.glassfish.jersey.containers', name: 'jersey-container-servlet', version: '2.23.2'
compile group: 'org.glassfish.jersey.test-framework.providers', name:'jersey-test-framework-provider-grizzly2', version:'2.23.2'
compile group: 'org.springframework', name:'spring-test', version:'4.3.2.RELEASE'
compile group: 'io.rest-assured', name:'rest-assured', version:'3.0.1'


// Spring
    compile group: 'org.springframework', name: 'spring-core', version: '4.3.2.RELEASE'
    compile group: 'org.springframework', name: 'spring-beans', version: '4.3.2.RELEASE'
    compile group: 'org.springframework', name: 'spring-web', version: '4.3.2.RELEASE'
    compile group: 'org.springframework', name: 'spring-jdbc', version: '4.3.2.RELEASE'
    compile group: 'org.springframework', name: 'spring-orm', version: '4.3.2.RELEASE'

    // Jersey-Spring bridge
    compile (group: 'org.glassfish.jersey.ext', name: 'jersey-spring3', version: '2.23.2'){
        exclude group: 'org.springframework', module: 'spring-core'
        exclude group: 'org.springframework', module: 'spring-web'
        exclude group: 'org.springframework', module: 'spring-beans'
        exclude group: 'org.springframework', module: 'spring-jdbc'
        exclude group: 'org.springframework', module: 'spring-orm'
    }