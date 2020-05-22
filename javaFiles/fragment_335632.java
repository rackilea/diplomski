openssl pkcs12 -export \
               -in ${WEBSERVICE}.cer -inkey ${WEBSERVICE}.key \
               -out ${WEBSERVICE}.p12 -name ${WEBSERVICE} \
               -password pass:${PASSWORD}

keytool -importkeystore \
        -srckeystore ${WEBSERVICE}.p12 -srcstoretype pkcs12 -srcalias ${WEBSERVICE} \
        -srcstorepass ${PASSWORD} \
        -destkeystore ${WEBSERVICE}.jks -deststoretype jks -destalias ${WEBSERVICE} \
        -deststorepass ${PASSWORD}