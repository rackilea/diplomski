Object fontDefinition = new UIDefaults.ProxyLazyValue("javax.swing.plaf.FontUIResource", null, new Object[] { "dialog", new Integer(Font.PLAIN), new Integer(12) });

java.util.Enumeration keys = UIManager.getDefaults().keys();
while (keys.hasMoreElements()) {
    Object key = keys.nextElement();
    Object value = UIManager.get(key);
    if (value instanceof javax.swing.plaf.FontUIResource) {
        UIManager.put(key, fontDefinition);
    }
}