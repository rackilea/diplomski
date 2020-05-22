@Configuration
@EnableWebFlux
public class WebConfig implements WebFluxConfigurer {
    @Override
    public void configureHttpMessageCodecs(ServerCodecConfigurer configurer) {
        configurer.registerDefaults(false);
        configurer.customCodecs().decoder(new Jaxb2XmlDecoder());   // <- here
        configurer.customCodecs().encoder(new Jaxb2XmlEncoder());   // <- here

    }
}