keytool -keystore server.jks -genkeypair -keyalg RSA 
# before j7 best to add -keysize 2048 see below 
keytool -keystore server.jks -certreq >server.csr 
openssl ca -in server.csr ... -out server.crt 
# or submit the CSR to a real CA and get its response

# then either install the chain all at once:
cat server.crt ca.crt >temp
keytool -keystore server.jks -importcert -file temp
# and confirm (need temp so stdin available for confirm;
# if using a public CA, can add -trustcacerts and use pipe instead)

# or install the certs separately, top down:
keytool -keystore server.jks -importcert -file ca.crt -alias ca
# and confirm, THEN
keytool -keystore server.jks -importcert -file server.crt 

# (last) response must be 'Certificate reply was installed'
# NOT merely 'Certificate was added' which means you messed up

# and similarly for client