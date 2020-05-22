compile('com.google.api-client:google-api-client:1.17.0-rc') {
    // Exclude artifacts that the Android SDK/Runtime provides.
    exclude(group: 'xpp3', module: 'xpp3')
    exclude(group: 'org.apache.httpcomponents', module: 'httpclient')
    exclude(group: 'junit', module: 'junit')
    exclude(group: 'com.google.android', module: 'android')
}