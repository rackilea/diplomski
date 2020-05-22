package your.package;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.LocalBean;
import javax.ejb.Startup;

@Singleton
@Startup
public class NewSessionBean {

    // This method will be invoked upon server startup (@PostConstruct & @Startup)
    @PostConstruct
    private void init() {
        int result = add(4, 5);
        System.out.println(result);
    }

    // This is your business method.
    public int add(int x, int y) {
        return x + y;
    }
}