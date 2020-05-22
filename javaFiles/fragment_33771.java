[libdefaults]
  forwardable = true
  dns_lookup_kdc = true
  dns_lookup_realm = true
  default_realm = YOUR.COMPANY

  default_tkt_enctypes = rc4-hmac aes256-cts aes128-cts des3-cbc-sha1 des-cbc-md5 des-cbc-crc
  default_tgs_enctypes = rc4-hmac aes256-cts aes128-cts des3-cbc-sha1 des-cbc-md5 des-cbc-crc
  permitted_enctypes   = rc4-hmac aes256-cts aes128-cts des3-cbc-sha1 des-cbc-md5 des-cbc-crc

[realms]
  YOUR.COMPANY = {
     kdc = your.company
  }

[domain_realm]
  .your.company = YOUR.COMPANY
  your.company  = YOUR.COMPANY