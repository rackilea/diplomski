apply plugin: ear

...

appengine {
    downloadSdk = true
    httpAddress = "0.0.0.0"
    jvmFlags = ['-Dcom.google.appengine.devappserver_module.default.port=8080',
                '-Dcom.google.appengine.devappserver_module.module1.port=8081']
    appcfg {
        email = "blahemail@domain.com"
        oauth2 = true
    }
}