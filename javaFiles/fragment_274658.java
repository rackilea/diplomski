private static final Object AA_TEXT_PROP = getAaTextProperty();

public static Object getAaTextProperty() {

    Object aatext = null;
    try {
        Class<?> c = Class.forName("sun.swing.SwingUtilities2");
        Field f = c.getField("AA_TEXT_PROPERTY_KEY");
        aatext = f.get(null);
    } catch (Exception e) {
        e.printStackTrace();
    }
    return aatext;
}
...

public AntialiasLabel(String label, HashMap<Key, Object> hints) {
    super(PALYNDROME);
    putClientProperty(AA_TEXT_PROP, null);
    ...
}