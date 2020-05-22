compile("org.apache.hadoop:hadoop-common:3.1.0") {
    exclude(group: 'org.slf4j')
    exclude(group: 'org.mortbay.jetty')
    exclude(group: 'javax.servlet.jsp')
    exclude(group: 'com.sun.jersey')
    exclude(group: 'log4j')
    exclude(group: 'org.apache.curator')
    exclude(group: 'org.apache.zookeeper')
    exclude(group: 'org.apache.kerby')
    exclude(group: 'com.google.protobuf')
}