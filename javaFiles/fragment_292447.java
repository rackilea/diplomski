@Bean
CamelContextConfiguration contextConfiguration() {
    return new CamelContextConfiguration() {
       @Override
        public void beforeApplicationStart(CamelContext camelContext) {
            // code goes in here
        }

        @Override
        public void afterApplicationStart(CamelContext camelContext) {
            // noop
        }
    };
}