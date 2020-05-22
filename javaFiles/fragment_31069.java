@Configuration
@ComponentScan("pl.mbrnwsk.sklep.controller")
public class ServletConfiguration {

    public AppConfiguration(){
        System.out.println("ServletConfiguration");
    }

    @Bean
    public ViewResolver viewResolver(){
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/");
        viewResolver.setSuffix(".jsp");
        return viewResolver;
    }
}