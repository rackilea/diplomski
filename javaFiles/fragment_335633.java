keytool -import -trustcacerts \
        -alias issuer -file issuer.pem \ 
        -keystore ${WEBSERVICE}.jks -storepass ${PASSWORD}
keytool -import -trustcacerts \
        -alias intermediate -file intermediate.pem \
        -keystore ${WEBSERVICE}.jks -storepass ${PASSWORD}
keytool -import -trustcacerts \
        -alias root -file root.pem \
        -keystore ${WEBSERVICE}.jks -storepass ${PASSWORD}