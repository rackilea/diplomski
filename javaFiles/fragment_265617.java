<Connector 
     port="8443" maxThreads="200"
     scheme="https" secure="true" SSLEnabled="true"
     keystoreFile="${path of key stokre}/keystore.jks" /*Put the keystoer path*/
     keystorePass="changeit"
     clientAuth="false" sslProtocol="TLS"/>