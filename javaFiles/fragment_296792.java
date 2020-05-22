@Component
public class A implements IStringGetter {    
    @Bean
    public IStringGetter getTheThing() {
        return new A();
    }    
    @Override
    public String getItGood() {
        return "I am an A";
    }    
}