String iconPath = sourceSettings.getSettingsDialogImage();        
    if(iconPath == null){
        iconPath = "";
    }
    final URL iconUrl = JmeSystem.class.getResource(iconPath.startsWith("/") ? iconPath : "/" + iconPath);
    if (iconUrl == null) {
        // *****LINE 112 below*****
        throw new AssetNotFoundException(sourceSettings.getSettingsDialogImage());
    }