public class ConfigSwingDemo extends JFrame {

    private Map<String, JTextField> fieldsMap = new HashMap<>(25);
    //...

    for (Object k : keys) {
        JLabel label = new JLabel(k.toString());
        JTextField field = new JTextField(configProps.getProperty(k.toString()), 10);
        fieldsMap.put(k.toString(), field);