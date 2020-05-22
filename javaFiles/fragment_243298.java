public class Ports {

    public static List<CommPortIdentifier> listCommPorts() {
      List<CommPortIdentifier> listOfPorts = new ArrayList<>(25);
      Enumeration ports = CommPortIdentifier.getPortIdentifiers();

      while (ports.hasMoreElements()) {
        CommPortIdentifier curPort = (CommPortIdentifier) ports.nextElement();

        //get only serial ports
        if (curPort.getPortType() == CommPortIdentifier.PORT_SERIAL) {
          listOfPorts.add(curPort);
        }
      }
      return listOfPorts;
    }

  }