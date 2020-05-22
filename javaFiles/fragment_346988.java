@Value("${local.server.port}")
int port

Configuration createConf() {
    def configuration = super.createConf()
    configuration.baseUrl = "http://localhost:$port"
    configuration
}