ObservableMap<Object, Object> properties = children.getProperties();
    for (Entry<Object, Object> entry : properties.entrySet()) {
        String key = (String) entry.getKey();
        if (key.equals("CPU")) {
            children.setVisible(true);
        } else {
            children.setVisible(false);
        }
    }