[libdefaults]
default_realm = DEV-MITROL.LOCAL
default_tkt_enctypes = rc4-hmac,aes256-cts-hmac-sha1-96,aes128-cts-hmac-sha1-96
default_tgs_enctypes = rc4-hmac,aes256-cts-hmac-sha1-96,aes128-cts-hmac-sha1-96
forwardable=true

[realms]
DEV-MITROL.LOCAL = {
kdc = AR-SRV-DC-007
}

[domain_realm]
dev-mitrol.local= DEV-MITROL.LOCAL
.dev-mitrol.local= DEV-MITROL.LOCAL