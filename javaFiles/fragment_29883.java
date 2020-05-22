/**
 * @return true if <code>defaults read -g AppleInterfaceStyle</code> has an exit status of <code>0</code> (i.e. _not_ returning "key not found").
 */
private boolean isMacMenuBarDarkMode() {
    try {
        // check for exit status only. Once there are more modes than "dark" and "default", we might need to analyze string contents..
        final Process proc = Runtime.getRuntime().exec(new String[] {"defaults", "read", "-g", "AppleInterfaceStyle"});
        proc.waitFor(100, TimeUnit.MILLISECONDS);
        return proc.exitValue() == 0;
    } catch (IOException | InterruptedException | IllegalThreadStateException ex) {
        // IllegalThreadStateException thrown by proc.exitValue(), if process didn't terminate
        LOG.warn("Could not determine, whether 'dark mode' is being used. Falling back to default (light) mode.");
        return false;
    }
}