public void onEnable() {
    try {
        setupConfig(getConfig());
        saveConfig();
    } catch (Exception e) {
        e.printStackTrace();
    }