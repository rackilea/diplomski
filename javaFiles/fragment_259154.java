POST /upload HTTP/1.1
Host: myhost
User-Agent: uploader/1.0
Accept: text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8
Accept-Charset: ISO-8859-1,utf-8;q=0.7,*;q=0.7
Content-Type: multipart/form-data; boundary=----------287032381131322
Content-Length: {sizeofcontent}

------------287032381131322
Content-Disposition: form-data; name="file"; filename="myfile.txt"
Content-Type: text/plain

My file content;
------------287032381131322--