server {
    listen 80;
    server_name *.domain.me;
    location / {
        return 301 https://$host$request_uri;
    }
}
server {
    listen 443 ssl;
    server_name *.domain.me;

    ssl_certificate /path/to/crt;
    ssl_certificate_key /path/to/key;


    location / {
        proxy_pass http://destinationIp:destinationPort;
        proxy_set_header Host $host;
    }
}