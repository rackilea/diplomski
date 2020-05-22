package module.a;

import org.osgi.framework.*;

public class Activator
    implements BundleActivator, ServiceListener {

  @Override
  public void start(BundleContext bc)
      throws Exception {

    System.out.println("*** started");
    bc.addServiceListener(this);
  }

  @Override
  public void stop(BundleContext bc)
      throws Exception {

    bc.removeServiceListener(this);
    System.out.println("*** stopped");
  }

  @Override
  public void serviceChanged(ServiceEvent se) {
    String s;

    switch (se.getType()) {
      case ServiceEvent.MODIFIED:
        s = "modified";
        break;
      case ServiceEvent.REGISTERED:
        s = "registered";
        break;
      case ServiceEvent.UNREGISTERING:
        s = "unregistered";
        break;
      default:
        s = "unknown";
    }

    System.out.println("= = = service changed: " + s);
  }

}