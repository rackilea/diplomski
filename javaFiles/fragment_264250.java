@Configuration
@ComponentScan(
        value = "some.package.path",
        includeFilters = {
                @Filter(type = ASSIGNABLE_TYPE, value = {
                        MyClass1.class,
                        MyClass2.class,
                        MyClass3.class
                })
        })
public class WebConfig extends WebMvcConfigurerAdapter {
...