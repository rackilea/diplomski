C:\Users\Desktop\Java>java TestHttpsPost
{"id":"PAY-0SM99950896487827KW4ZAZA","create_time":"2015-07-30T02:48:04Z","updat
e_time":"2015-07-30T02:48:04Z","state":"created","intent":"sale","payer":{"payme
nt_method":"paypal","payer_info":{"shipping_address":{}}},"transactions":[{"amou
nt":{"total":"7.47","currency":"USD","details":{"subtotal":"7.47"}},"related_res
ources":[]}],"links":[{"href":"https://api.sandbox.paypal.com/v1/payments/paymen
t/PAY-0SM99950896487827KW4ZAZA","rel":"self","method":"GET"},{"href":"https://ww
w.sandbox.paypal.com/cgi-bin/webscr?cmd=_express-checkout&token=EC-8F164253W5887
9412","rel":"approval_url","method":"REDIRECT"},{"href":"https://api.sandbox.pay
pal.com/v1/payments/payment/PAY-0SM99950896487827KW4ZAZA/execute","rel":"execute
","method":"POST"}]}
Response code:201
Response message:Created