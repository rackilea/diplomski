@Bean
    public CommandLineRunner commandRunner() {
        return (args) -> {
            TwilioRespondToSMS();
            // Whatever other code ...
        }
    }