@Configuration
public class MyConfiguration{

    @Bean
    @Scope("prototype")
    public MyValidator myValidator(){
        return new MyValidator();
    }

    @Bean
    public ValidatorHolder validatorHolder(){
        return new ValidatorHolder(){
            @Override public MyValidator getMyValidator(){
                return myValidator();
            }
        };
    }
}