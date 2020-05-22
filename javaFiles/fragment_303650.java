@Configuration
@EnableScheduling
@EnableAsync
@ComponentScan({"configs", "models"})
public class WebConfig 
{
    @Bean RequestMappingHandlerAdapter requestMappingHandlerAdapter()
    {
        RequestMappingHandlerAdapter reqMapHAdapter=new RequestMappingHandlerAdapter();

        ArrayList<HttpMessageConverter<?>> msgConvs=new ArrayList<>();

        StringHttpMessageConverter stringConverter = new StringHttpMessageConverter(Charset.forName("UTF-8"));
        stringConverter.setSupportedMediaTypes(Arrays.asList(MediaType.TEXT_PLAIN));
        msgConvs.add(stringConverter);

        reqMapHAdapter.setMessageConverters(msgConvs);
        return reqMapHAdapter;
    }

    ...
}