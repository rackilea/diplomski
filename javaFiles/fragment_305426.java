# Create PEM: cat cert.crt cert.key ca.crt > /etc/ssl/certs/cert.pem

global
    tune.ssl.default-dh-param 2048
    ssl-default-bind-options no-sslv3 no-tls-tickets force-tlsv12
    ssl-default-bind-ciphers ECDH+AESGCM:DH+AESGCM:ECDH+AES256:DH+AES256:ECDH+AES128:DH+AES:ECDH+3DES:DH+3DES:RSA+AESGCM:RSA+AES:RSA+3DES:!aNULL:!MD5:!DSS
    chroot /var/lib/haproxy
    user haproxy
    group haproxy

defaults
    timeout connect 10000ms
    timeout client 60000ms
    timeout server 60000ms

frontend fe_https
    mode tcp
    rspadd Strict-Transport-Security:\ max-age=31536000;\ includeSubDomains;\ preload
    rspadd X-Frame-Options:\ DENY
    bind *:443 ssl crt /etc/ssl/certs/cert.pem alpn h2,http/1.1
    default_backend be_http

backend be_http
    mode tcp
    server domain 127.0.0.1:8080
    # compression algo gzip # does not work in mode "tcp"
    # compression type text/html text/css text/javascript application/json