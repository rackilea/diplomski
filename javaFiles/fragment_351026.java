@Configuration
@ConditionalOnClass(name = "org.springframework.cloud.netflix.hystrix.HystrixHealthIndicator")
public class XpsHystrixAutoConfiguration {   
    @Bean
    @ConditionalOnEnabledHealthIndicator("xspHystrix")
    public XspHystrixHealthIndicator xpsHystrixHealthIndicator() {
        return new XspHystrixHealthIndicator();
    }  
}