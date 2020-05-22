import javax.servlet.http.HttpSessionActivationListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class SessionListener implements HttpSessionListener, HttpSessionAttributeListener, HttpSessionBindingListener, HttpSessionActivationListener {

public void valueBound(HttpSessionBindingEvent event) {
    System.out.println("valueBound: " + event.getName() + " : " + event.getValue());
    System.out.println("  session: " + event.getSession().getId());
    this.printStackTrace();
}

public void valueUnbound(HttpSessionBindingEvent event) {
    System.out.println("valueUnbound: " + event.getName() + " : " + event.getValue());
    System.out.println("  session: " + event.getSession().getId());
    this.printStackTrace();
}

public void attributeAdded(HttpSessionBindingEvent event) {
    System.out.println("attributeAdded: " + event.getName() + " : " + event.getValue());
    System.out.println("  session: " + event.getSession().getId());
    this.printStackTrace();
}

public void attributeRemoved(HttpSessionBindingEvent event) {
    System.out.println("attributeRemoved: " + event.getName() + " : " + event.getValue());
    System.out.println("  session: " + event.getSession().getId());
    this.printStackTrace();
}

public void attributeReplaced(HttpSessionBindingEvent event) {
    System.out.println("attributeReplaced: " + event.getName() + " : " + event.getValue());
    System.out.println("  session: " + event.getSession().getId());
    this.printStackTrace();
}

public void sessionCreated(HttpSessionEvent event) {
    System.out.println("sessionCreated: " + event.getSession().getId());
    this.printStackTrace();
}

public void sessionDestroyed(HttpSessionEvent event) {
    System.out.println("sessionDestroyed: " + event.getSession().getId());
    this.printStackTrace();
}

public void sessionDidActivate(HttpSessionEvent event) {
    System.out.println("sessionDidActivate: " + event.getSession().getId());
    this.printStackTrace();
}

@Override
public void sessionWillPassivate(HttpSessionEvent event) {
    System.out.println("sessionWillPassivate: " + event.getSession().getId());
    this.printStackTrace();
}

private void printStackTrace() {
    try {
        if (true) {
            throw new Exception();
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
}
}