$ dig login.salesforce.com

; <<>> DiG 9.8.3-P1 <<>> login.salesforce.com
;; global options: +cmd
;; Got answer:
;; ->>HEADER<<- opcode: QUERY, status: NOERROR, id: 28719
;; flags: qr rd ra; QUERY: 1, ANSWER: 5, AUTHORITY: 0, ADDITIONAL: 0

;; QUESTION SECTION:
;login.salesforce.com.      IN  A

;; ANSWER SECTION:
login.salesforce.com.   2288    IN  CNAME   login.gslb2.salesforce.com.
login.gslb2.salesforce.com. 57  IN  A   136.147.59.44
login.gslb2.salesforce.com. 57  IN  A   136.147.57.172
login.gslb2.salesforce.com. 57  IN  A   136.147.58.44
login.gslb2.salesforce.com. 57  IN  A   136.147.58.172