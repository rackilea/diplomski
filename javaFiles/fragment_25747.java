public class DoStuff implement ApplicationContextAware {    
private ApplicationContext CONTEXT;
public void setApplicationContext(ApplicationContext context) throws BeansException {
    CONTEXT = context;
}

    public void originalMethod() {           
        getSpringProxy().doDatabaseStuff()              
        doNonDatabaseStuff()       
    }

    private DoStuff getSpringProxy() {
        return context.getBean(this.getClass());     
    } 
    @Transactional       
    public void doDatabaseStuff() {           
        ...       
    }          

    public void doNonDatabaseStuff() {           
        ...       
    }   
}