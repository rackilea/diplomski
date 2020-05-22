http -a a:a DELETE 127.0.0.1:8080/db/coll
HTTP/1.1 409 Conflict
...
ETag: 58653f6b2d174c09c590262a

{
    "http status code": 409, 
    "http status description": "Conflict", 
    "message": "The collection's ETag must be provided using the 'If-Match' header."
}