package usage;

import java.util.*;
import org.apache.felix.framework.*;
import org.apache.felix.framework.util.*;
import org.osgi.framework.*;

public class Main {

  static class HostActivator
      implements BundleActivator {

    private BundleContext context = null;

    @Override
    public void start(BundleContext bc) {
      context = bc;
    }

    @Override
    public void stop(BundleContext bc) {
      context = null;
    }

    public BundleContext getContext() {
      return context;
    }

  }

  public static void main(String[] args)
      throws Exception {

    Map<String, Object> map = new HashMap<String, Object>();

    map.put(Constants.FRAMEWORK_SYSTEMPACKAGES_EXTRA,
        "some.module.i.dont.know; version=1.0.0");

    HostActivator activator = new HostActivator();

    List<Object> list = new LinkedList<Object>();
    list.add(activator);
    map.put(FelixConstants.SYSTEMBUNDLE_ACTIVATORS_PROP, list);

    Felix f = new Felix(map);

    System.out.println("starting OSGI...");
    f.start();

    Bundle b = f.getBundleContext().installBundle(
        "file:../OsgiModuleA/dist/OsgiModuleA.jar"); // dirty path ;)
    String bName = b.getLocation();

    System.out.println("starting bundle " + bName);
    b.start();

    Set<String> inUse = new HashSet<String>();
    for (ServiceReference sr : f.getServicesInUse()) {
      inUse.add(sr.toString());
    }
    for (ServiceReference sr : f.getRegisteredServices()) {
      String flag = (inUse.contains(sr.toString()) ? "[in use]" : "[      ]");
      System.out.println("+ registered service: " + flag + " " + sr.toString());
    }

    System.out.println("stopping bundle " + bName);
    b.stop();

    System.out.println("uninstalling bundle " + bName);
    b.uninstall();

    System.out.println("stopping...");
    f.stop();
    f.waitForStop(1000);
  }

}