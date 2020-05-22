[libdefaults]
renew_lifetime = 7d
forwardable = true
default_realm = DOMAIN 
ticket_lifetime = 24h
dns_lookup_realm = false
dns_lookup_kdc = false

[realms]
DOMAIN = {
  admin_server = ms-dcs.DOMAIN 
  kdc = ms-dcs.DOMAIN 
}

[domain_realm]
.DOMAIN  = DOMAIN 
DOMAIN  = DOMAIN