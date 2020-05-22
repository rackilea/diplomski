@Service 
public class Foo { 
    @Autowired private AutowireCapableBeanFactory factory; 

    private <T> T createAutowiredObject(Class<T> c) {
        return factory.createBean(c);
    }
    ...
}