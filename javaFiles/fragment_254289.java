package de.scrum_master.app;

import javax.swing.event.EventListenerList;
import org.ietf.jgss.GSSException;
import org.ietf.jgss.Oid;
import org.omg.CORBA.IntHolder;
import org.w3c.dom.bootstrap.DOMImplementationRegistry;
import org.xml.sax.InputSource;

// Internal Sun/Oracle-specific JDK classes,
// not recommended for JDK- and version-agnostic use
import sun.util.calendar.CalendarUtils;
import com.sun.beans.finder.BeanInfoFinder;

public class Application {
    public static void main(String[] args)
        throws GSSException, ClassNotFoundException, InstantiationException,
        IllegalAccessException, ClassCastException
    {
        sayHelloTo("world");
        Foo.doSomething();
        new Oid("1.2.840.113554.1.2.2").getDER();
        System.out.println("Process ID (PID) = " + getPID());
        new IntHolder(11)._type();
        DOMImplementationRegistry.newInstance().getDOMImplementation("XML 3.0");
        new InputSource().setEncoding("UTF-8");
        new EventListenerList().getListenerCount();

        // Internal Sun/Oracle-specific JDK classes,
        // not recommended for JDK- and version-agnostic use
        new BeanInfoFinder().getPackages();
        new CalendarUtils().isGregorianLeapYear(2015);
    }

    public static void sayHelloTo(String visitor) {
        System.out.println("Hello " + visitor);
    }

    public static long getPID() {
        String processName = java.lang.management.ManagementFactory.getRuntimeMXBean().getName();
        return Long.parseLong(processName.split("@")[0]);
    }
}