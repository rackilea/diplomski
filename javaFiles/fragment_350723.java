// copy progress bar defaults
HashMap<Object, Object> progressDefaults = new HashMap<>();
for(Map.Entry<Object, Object> entry : UIManager.getDefaults().entrySet()){
    if(entry.getKey().getClass() == String.class && ((String)entry.getKey()).startsWith("ProgressBar")){
        progressDefaults.put(entry.getKey(), entry.getValue());
    }
}

// set nimbus
UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");

// copy back progress bar defaults
for(Map.Entry<Object, Object> entry : progressDefaults.entrySet()){
    UIManager.getDefaults().put(entry.getKey(), entry.getValue());
}