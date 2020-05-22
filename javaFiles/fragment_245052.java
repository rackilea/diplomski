@Controller
public class ServletConfig {
    @Bean
    public EmbeddedServletContainerCustomizer containerCustomizer() {
      return (container -> {
        container.setPort(8012);
    });
}