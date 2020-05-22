public List<String> getAvailablePorts() {

    List<String> list = new ArrayList<String>();

    Enumeration portList = CommPortIdentifier.getPortIdentifiers();

    while (portList.hasMoreElements()) {
        CommPortIdentifier portId = (CommPortIdentifier) portList.nextElement();
        if (portId.getPortType() == CommPortIdentifier.PORT_SERIAL) {
            list.add(portId.getName());
        }
    }

    return list;
}