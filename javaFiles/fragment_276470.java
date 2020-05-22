@Component
public class Bootstrap implements ApplicationListener<ContextRefreshedEvent> {
    @Override
    void onApplicationEvent(ContextRefreshedEvent event) 
        ...  
    }    
}