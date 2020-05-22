/**
 * Resets the preferences controlled by this manager to their default settings
 */
public void resetToDefaultSettings(){
  JDIDebugPlugin.getDefault().getPluginPreferences().setToDefault(JDIDebugPlugin.PREF_SHOW_REFERENCES_IN_VAR_VIEW);
  JDIDebugPlugin.getDefault().getPluginPreferences().setToDefault(JDIDebugPlugin.PREF_ALL_REFERENCES_MAX_COUNT);
  JDIDebugPlugin.getDefault().getPluginPreferences().setToDefault(JDIDebugPlugin.PREF_ALL_INSTANCES_MAX_COUNT);
}