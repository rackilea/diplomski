ArrayList<String> serialports = new ArrayList<String>();
serialports.add(portId.getName());
String[] ports = new String[serialports.size()];
ports = serialports.toArray(ports); 
ComboBoxModel<String> model = new DefaultComboBoxModel<>(ports);
GUI.jComboBox2.setModel(model);