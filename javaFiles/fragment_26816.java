cd /etc/ssl/certs
for f in *.0 ; do openssl x509 -in $f -issuer | head -1 > /tmp/$f.issuer ; openssl x509 -in $f -subject | head -1 > /tmp/$f.subject ; done
 cd /tmp
 sed -i -e s/issuer=// *.issuer
 sed -i -e s/subject=// *.subject
 cd /etc/ssl/certs/
 for f in *.0 ; do diff -u /tmp/$f.issuer /tmp/$f.subject ; done