POST /url HTTP/1.1
Content-Length: 739
Content-Type: multipart/form-data; boundary=L2EqtNqIEXOWRCYYrYH8FSP1JAD65wz6c
Host: 127.0.0.1:8090
Connection: Keep-Alive
User-Agent: Apache-HttpClient/4.3.6 (java 1.5)
Accept-Encoding: gzip,deflate

--L2EqtNqIEXOWRCYYrYH8FSP1JAD65wz6c
Content-Disposition: form-data; name="input1"
Content-Type: text/plain; charset=ISO-8859-1
Content-Transfer-Encoding: 8bit

data1
--L2EqtNqIEXOWRCYYrYH8FSP1JAD65wz6c
Content-Disposition: form-data; name="input2"
Content-Type: text/plain; charset=ISO-8859-1
Content-Transfer-Encoding: 8bit

data2
--L2EqtNqIEXOWRCYYrYH8FSP1JAD65wz6c
Content-Disposition: form-data; name="input3"
Content-Type: text/plain; charset=ISO-8859-1
Content-Transfer-Encoding: 8bit

data3
--L2EqtNqIEXOWRCYYrYH8FSP1JAD65wz6c
Content-Disposition: form-data; name="file"; filename="myFile.dat"
Content-Type: application/octet-stream
Content-Transfer-Encoding: binary


--L2EqtNqIEXOWRCYYrYH8FSP1JAD65wz6c--