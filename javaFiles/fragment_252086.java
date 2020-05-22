apply plugin:'application'

....

dependencies {
    ....
    runtime  'mysql:mysql-connector-java-commercial:5.1.13'
}

mainClassName = "Collector"

run {
    args 'arg1'
    jvmArgs '-agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=10000'
}