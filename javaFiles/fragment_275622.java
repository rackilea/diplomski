/** Service class */

import javax.ejb.Stateless;

@Stateless
public class Service {

    public void upload(final Callback callback) {
        callback.call();
    }

}

/** Callback class */

public class Callback {

    public void call() {
        System.out.println(this + " called.");
    }

}

/** Trigger class */

import javax.ejb.EJB;
import javax.ejb.Schedule;
import javax.ejb.Singleton;

@Singleton
public class Trigger {

    @EJB
    Service service;

    @Schedule(second = "*/5", minute = "*", hour = "*", persistent = false)
    public void triggerService() {
        System.out.println("Trigger Service call");
        service.upload(new Callback());
        //or by JNDI lookup and method overriding
        try {
           Service serviceByLookup = (Service) InitialContext.doLookup("java:module/Service");
           serviceByLookup.upload(new Callback() {
               @Override
               public void call() {
                   System.out.println("Overriden: " + super.toString());
               }
           });

       } catch (final NamingException e) {
           // TODO Auto-generated catch block
           e.printStackTrace();
       }
    }
}