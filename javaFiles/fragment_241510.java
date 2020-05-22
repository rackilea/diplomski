compile 'commons-codec:commons-codec:1.10'
compile 'org.apache.commons:commons-lang3:3.6'
compile 'commons-io:commons-io:2.6'
compile('org.apache.httpcomponents:httpmime:4.3.6') {
    exclude module: 'httpclient'
}