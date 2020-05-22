MacBook$ sudo ngrep -W byline -d en0 "" host www.whatarecookies.com
interface: en0 (192.168.11.0/255.255.255.0)
filter: (ip) and ( dst host www.whatarecookies.com )
#####
T 192.168.11.70:56267 -> 54.228.218.117:80 [AP]
GET /cookietest.asp HTTP/1.1.
User-Agent: Jakarta Commons-HttpClient/3.1.
Host: www.whatarecookies.com.
.

####
T 54.228.218.117:80 -> 192.168.11.70:56267 [A]
HTTP/1.1 200 OK.
Server: nginx/1.4.0.
Date: Wed, 27 Nov 2013 10:22:14 GMT.
Content-Type: text/html; charset=iso-8859-1.
Content-Length: 36397.
Connection: keep-alive.
Vary: Accept-Encoding.
Vary: Cookie,Host,Accept-Encoding.
Set-Cookie: active_template::468=%2Fresponsive%2Fthree_column_inner_ad; expires=Fri, 29-Nov-2013 10:22:01 GMT; path=/; domain=whatarecookies.com; httponly.
Set-Cookie: 3b74de5a1c2f311bee7bca5c368aaa4e=b326b5062b2f0e69046810717534cb09; expires=Thu, 27-Nov-2014 10:22:01 GMT.
X-Middleton-Response: 200.
Cache-Control: max-age=0, no-cache.
X-Mod-Pagespeed: 1.7.30.1-3609.
.
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN" "http://www.w3.org/TR/1998/REC-html40-19980424/loose.dtd">
...

##
T 192.168.11.70:56267 -> 54.228.218.117:80 [AP]
GET /cookietest.asp HTTP/1.1.
User-Agent: Jakarta Commons-HttpClient/3.1.
Host: www.whatarecookies.com.
Cookie: active_template::468=%2Fresponsive%2Fthree_column_inner_ad.
Cookie: 3b74de5a1c2f311bee7bca5c368aaa4e=b326b5062b2f0e69046810717534cb09.
.

##
T 54.228.218.117:80 -> 192.168.11.70:56267 [A]
HTTP/1.1 200 OK.
Server: nginx/1.4.0.
Date: Wed, 27 Nov 2013 10:22:18 GMT.
Content-Type: text/html; charset=iso-8859-1.
Content-Length: 54474.
Connection: keep-alive.
Vary: Accept-Encoding.
Vary: Cookie,Host,Accept-Encoding.
Set-Cookie: active_template::468=%2Fresponsive%2Fthree_column_inner_ad%2C+3b74de5a1c2f311bee7bca5c368aaa4e%3Db326b5062b2f0e69046810717534cb09; expires=Fri, 29-Nov-2013 10:22:05 GMT; path=/; domain=whatarecookies.com; httponly.
Set-Cookie: 3b74de5a1c2f311bee7bca5c368aaa4e=b326b5062b2f0e69046810717534cb09; expires=Thu, 27-Nov-2014 10:22:05 GMT.
X-Middleton-Response: 200.
Cache-Control: max-age=0, no-cache.
X-Mod-Pagespeed: 1.7.30.1-3609.
.
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN" "http://www.w3.org/TR/1998/REC-html40-19980424/loose.dtd">
...