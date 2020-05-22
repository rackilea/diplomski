compile('com.google.api-client:google-api-client:1.17.0-rc') {
    // Exclude artifacts that the Android SDK/Runtime provides.
    exclude('xpp3:xpp3')
    exclude('org.apache.httpcomponents:httpclient')
    exclude('junit:junit')
    exclude('com.google.android:android')
}