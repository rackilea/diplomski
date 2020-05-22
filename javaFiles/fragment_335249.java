$ dig @8.8.8.8 api.sandbox.amazon.co.jp

; <<>> DiG 9.8.2rc1-RedHat-9.8.2-0.47.rc1.el6_8.4 <<>> @8.8.8.8 api.sandbox.amazon.co.jp
; (1 server found)
;; global options: +cmd
;; Got answer:
;; ->>HEADER<<- opcode: QUERY, status: NOERROR, id: 59419
;; flags: qr rd ra; QUERY: 1, ANSWER: 2, AUTHORITY: 0, ADDITIONAL: 0

;; QUESTION SECTION:
;api.sandbox.amazon.co.jp.      IN      A

;; ANSWER SECTION:
api.sandbox.amazon.co.jp. 899   IN      CNAME   api-sandbox.amazon.co.jp.
api-sandbox.amazon.co.jp. 59    IN      A       54.240.252.254

;; Query time: 111 msec
;; SERVER: 8.8.8.8#53(8.8.8.8)
;; WHEN: Wed Jan 25 22:59:47 2017
;; MSG SIZE  rcvd: 84