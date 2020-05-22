http -a a:a 127.0.0.1:8080/db/coll?pagesize=0
HTTP/1.1 200 OK
...
ETag: 58653f6b2d174c09c590262a**

{
    "_embedded": [], 
    "_etag": {
        "$oid": "58653f6b2d174c09c590262a"
    }, 
    "_id": "coll", 
    "_returned": 0,
}