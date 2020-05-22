implementation('com.amazon.alexa:alexa-skills-kit:1.2') {
   exclude group: 'com.fasterxml.jackson.core', module: 'jackson-core'
}

implementation('com.google.api-client:google-api-client:1.19.1') {
   exclude group: 'com.fasterxml.jackson.core', module: 'jackson-core'
}