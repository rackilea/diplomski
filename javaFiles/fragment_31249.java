private Boolean processPluginUpgrading() {
    final Version version = getDefault().getBundle().getVersion();
    final IPreferenceStore preferenceStore = getDefault().getPreferenceStore();
    final String preferenceName = "lastVersionActivated";
    final String lastVersionActivated = preferenceStore.getString(preferenceName);
    final boolean upgraded = 
            "".equals(lastVersionActivated)
            || (version.compareTo(new Version(lastVersionActivated)) > 0);
    preferenceStore.setValue(preferenceName, version.toString());
    return upgraded;
}