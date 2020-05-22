@Test
public void testClient () throws IOException {

    DefaultListModel<String> vm_list = new DefaultListModel<String>();
    Properties props = new Properties();
    FileInputStream fis = null;
    fis = new FileInputStream("config.properties");
    props.load(fis);
    for (Entry<Object, Object> entry : props.entrySet()) {
        System.out.println("Entry key:" + entry.getKey() + " value:" + entry.getValue());
        String key = (String)entry.getKey();
        if (key.endsWith("Client")) {
            vm_list.addElement(key); // maybe want to add entry.getValue() instead
        }
    }
    // return vm_list;      
}