@SpringBootApplication
open class Backend {

    @Configuration
    @Profile("integration-test")
    open class IntegrationTestPostConstruct {

        @PostConstruct
        fun postConstruct() {
            // do stuff in integration tests
        }

    }

    @Configuration
    @Profile("test")
    open class TestPostConstruct {

        @PostConstruct
        fun postConstruct() {
            // do stuff in normal tests
        }

    }

}