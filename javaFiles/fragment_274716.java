version: "3"

services:

  server:
    image: nginx:1.17.3
    restart: always
    container_name: nginx
    expose:
    - "80"
    ports:
    - 8888:80

  client:
    image: busybox:1.31.0
    restart: always
    depends_on:
    - server
    container_name: busybox
    command:
    - ash
    - -c
    - |
      while true;
      do
        wget --spider http://server:80 2>&1
        sleep 5s;
      done;