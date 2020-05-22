{
  "io.shido.core.verticle.AuthVerticle": { },
  "io.shido.core.verticle.DialPadVerticle": { },
  "io.shido.core.verticle.HttpServerVerticle": {
    "config": {
      "hostname": "0.0.0.0",
      "port": 9081,
      "certPath": "server-cert.pem",
      "keyPath": "server-key.pem",
      "useAlpn": true,
      "useSsl": true
    },
    "instances": 5
  }
}