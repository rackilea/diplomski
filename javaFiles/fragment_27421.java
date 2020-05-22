@ ~$ curl --verbose  http://www.washingtonpost.com/wp-srv/simulation/simulation_test.json


* About to connect() to www.washingtonpost.com port 80 (#0)
*   Trying 23.204.109.48...
* connected
* Connected to www.washingtonpost.com (23.204.109.48) port 80 (#0)
> GET /wp-srv/simulation/simulation_test.json HTTP/1.1
> User-Agent: curl/7.28.1-DEV
> Host: www.washingtonpost.com
> Accept: */*
> 
< HTTP/1.1 200 OK
< Server: webserver
< Content-Type: text/plain
< Last-Modified: Wed, 12 Feb 2014 21:16:22 GMT
< Content-Length: 58187
< ETag: "e34b-52fbe4a6"
< Accept-Ranges: bytes
< Date: Mon, 10 Mar 2014 16:54:42 GMT
< Connection: keep-alive
< 
{
"posts": [