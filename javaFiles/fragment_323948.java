@Bean
public IntegrationFlow wireTapFlow5() {
    return f -> f
            .wireTap(sf -> sf
                    .<String, String>transform(String::toUpperCase)
                    .channel(c -> c.queue("wireTapSubflowResult")))
            .channel("nullChannel");
}