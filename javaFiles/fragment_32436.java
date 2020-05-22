compile group: 'com.fasterxml.jackson.core', name: 'jackson-databind', version: '2.9.3'
compile group: 'org.apache.logging.log4j', name: 'log4j-api', version: '2.10.0'
compile group: 'org.apache.logging.log4j', name: 'log4j-core', version: '2.10.0'
compile group: 'com.lmax', name: 'disruptor', version: '3.3.7' version: '2.12.0'
compile (group: 'org.springframework.amqp', name: 'spring-rabbit', version: '2.0.2.RELEASE') {
    exclude group: 'com.fasterxml.jackson.core', module: 'jackson-databind'
}