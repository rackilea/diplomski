@Configuration
public class DandelionConfig {

    @Bean
    public DandelionDialect dandelionDialect() {
        return new DandelionDialect();
    }

    @Bean
    public DataTablesDialect dataTablesDialect(){
        return new DataTablesDialect();
    }

    @Bean
    public Filter dandelionFilter() {
        return new DandelionFilter();
    }

    @Bean
    public ServletRegistrationBean dandelionServletRegistrationBean() {
        return new ServletRegistrationBean(new DandelionServlet(), "/dandelion-assets/*");
    }
}