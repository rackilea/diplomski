/**
 * Sets whether the WebView should enable plugins. The default is false.
 *
 * @param flag true if plugins should be enabled
 * @deprecated This method has been deprecated in favor of
 *             {@link #setPluginState}
 * @hide Since API level {@link android.os.Build.VERSION_CODES#JELLY_BEAN_MR2}
 */
@Deprecated
public synchronized void setPluginsEnabled(boolean flag) {
    throw new MustOverrideException();
}