private void initComponents() {
 List<String> COM = new ArrayList<String>();
 Enumeration portList = CommPortIdentifier.getPortIdentifiers();
 while (portList.hasMoreElements()) {
    CommPortIdentifier portId = (CommPortIdentifier) portList.nextElement();
    if (portId.getPortType() == CommPortIdentifier.PORT_PARALLEL) {
        System.out.println("No COM ports found");
        } else {
        COM.add(portId.getName());
    }
}

 selectedComPort = new JComboBox(COM.toArray(new String[COM.size()]));
 ....
}