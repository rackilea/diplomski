POST / HTTP/1.1
Accept-Encoding: gzip
Accept: text/xml, text/html, image/gif, image/jpeg, *; q=.2, */*; q=.2
SOAPAction: ""
Content-Type: text/xml; charset=utf-8
Cache-Control: no-cache
Pragma: no-cache
User-Agent: Java/1.7.0_55
Host: localhost:1234
Connection: keep-alive
Content-Length: 154

<SOAP-ENV:Envelope xmlns:SOAP-ENV="http://schemas.xmlsoap.org/soap/envelope/"><SOAP-ENV:Header/><SOAP-ENV:Body><message xmlns=\"http://tempuri.org\">Hello Web Service World</message></SOAP-ENV:Body></SOAP-ENV:Envelope>