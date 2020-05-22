server {
      listen 8082;
      location / {
         proxy_pass http://helloworld;
      }
      location /saytime/ {
         proxy_pass http://firstservlet;
      }
   }

   upstream helloworld {
      server http://127.0.0.1:8081/;
   }

   upstream firstserver {
      server http://127.0.0.1:8080/;
   }