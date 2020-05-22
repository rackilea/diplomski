backend "inmem" {
  address = "127.0.0.1:8500"
  path = "vault"
}

listener "tcp" {
    address = "127.0.0.1:9000"
    tls_disable = 1
}

listener "tcp" {
 address = "127.0.0.1:8200"
 tls_disable = 0
 tls_cert_file = "C:/my/server.pem"
 tls_key_file = "C:/my/serverkey.pkcs8"
}