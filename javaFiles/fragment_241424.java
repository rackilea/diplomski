@EnableWebMvc
@Configuration
public class ApplicationConfiguration extends WebMvcConfigurerAdapter
    @Override
    public void addReturnValueHandlers(final List<HandlerMethodReturnValueHandler> returnValueHandlers) {
        List<HttpMessageConverter<?>> messageConverters = new ArrayList<>();
        messageConverters.add(new MappingJackson2HttpMessageConverter());
        returnValueHandlers.add(new ResultResponseHandlerMethodProcessor(messageConverters));
    }
}