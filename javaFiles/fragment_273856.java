POST /ws/hello HTTP/1.1
SOAPAction: ""
Accept: text/xml, multipart/related, text/html, image/gif, image/jpeg, *; q=.2,   */*; q=.2
Content-Type: text/xml; charset=utf-8
User-Agent: Java/1.6.0_13
Host: localhost:9999
Connection: keep-alive
Content-Length: 224

<?xml version="1.0" ?>
<S:Envelope xmlns:S="http://schemas.xmlsoap.org/soap/envelope/">
    <S:Body>
        <ns2:getHelloWorldAsString xmlns:ns2="http://ws.mkyong.com/">
            <arg0>test</arg0>
        </ns2:getHelloWorldAsString>
    </S:Body>
</S:Envelope>