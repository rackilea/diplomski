POST /url HTTP/1.1
Content-Length: 468
Content-Type: multipart/form-data; boundary=mN_bWsS4QQnlPJksvinB_WUpl2Qi6zVVElUEEBKh
Host: 127.0.0.1:8090
Connection: Keep-Alive
User-Agent: Apache-HttpClient/4.3.6 (java 1.5)
Accept-Encoding: gzip,deflate

--mN_bWsS4QQnlPJksvinB_WUpl2Qi6zVVElUEEBKh
Content-Disposition: form-data; name="json"
Content-Type: application/json; charset=UTF-8
Content-Transfer-Encoding: 8bit

{"input1":"data1","input2":"data2","input3":"data3"}
--mN_bWsS4QQnlPJksvinB_WUpl2Qi6zVVElUEEBKh
Content-Disposition: form-data; name="file"; filename="myFile.dat"
Content-Type: text/plain; charset=ISO-8859-1
Content-Transfer-Encoding: binary


--mN_bWsS4QQnlPJksvinB_WUpl2Qi6zVVElUEEBKh--