POST http://localhost:8080/orders
Accept: application/json
Content-Type: application/json
{
  "id":"23423423",
  "clientName":"Roman C",
  "amount": 1000
}
 -- response --
201 
Content-Language:  en-US
Content-Length:  54
Content-Type:  application/json;charset=UTF-8
Date:  Sat, 07 Oct 2017 20:44:39 GMT
ETag:  -735433458
Location:  http://localhost:8080/orders/23423423

{"amount":1000,"clientName":"Roman C","id":"23423423"}