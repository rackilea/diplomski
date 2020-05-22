compile ('org.igniterealtime.smack:smack-android:4.2.0') {
      exclude  group:'de.measite.minidns'
    }
    compile ('org.igniterealtime.smack:smack-tcp:4.2.0') {
      exclude  group:'de.measite.minidns'
    }
    compile group: 'de.measite.minidns', name: 'minidns-hla', version: 
    '0.2.2'