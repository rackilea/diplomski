[libdefaults]
    default_realm = DOMAINNAME.NEW
    forwardable = true
    default_tkt_enctypes = aes256-cts aes128-cts rc4-hmac
    default_tgs_enctypes = aes256-cts aes128-cts rc4-hmac
    permitted_enctypes  = aes256-cts aes128-cts rc4-hmac
[realms]
        DOMAINNAME.NEW = {
                kdc = KDCSERVERNAME
        default_domain = DOMAINNAME.NEW
        }

[domain_realm]
        .domainname.new = DOMAINNAME.NEW
        domainname.new = DOMAINNAME.NEW