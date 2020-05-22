$ curl -v http://localhost:8080/contacts/ -X POST -d '{ "contact": { "name": "foo" } }' -H 'Content-Type: application/json' && echo
*   Trying ::1...
* Connected to localhost (::1) port 8080 (#0)
> POST /contacts/ HTTP/1.1
> Host: localhost:8080
> User-Agent: curl/7.43.0
> Accept: */*
> Content-Type: application/json
> Content-Length: 32
> 
* upload completely sent off: 32 out of 32 bytes
< HTTP/1.1 201 Created
< Server: Apache-Coyote/1.1
< X-Application-Context: application
< Content-Type: application/json;charset=UTF-8
< Content-Length: 26
< Date: Fri, 10 Jun 2016 13:24:23 GMT
< 
* Connection #0 to host localhost left intact
{"contact":{"name":"foo"}}