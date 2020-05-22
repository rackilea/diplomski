compile('com.google.endpoints:endpoints-framework:2.0.10') {
    exclude group: 'com.google.guava', module: 'guava-jdk5'
}
compile('com.google.appengine.tools:appengine-gcs-client:0.7') {
    exclude group: 'com.google.guava', module: 'guava-jdk5'
}
compile('com.google.apis:google-api-services-androidpublisher:v2-rev48-1.23.0') {
    exclude group: 'com.google.guava', module: 'guava-jdk5'
}