@Override    
public void create() {
    ...
    final Preferences prefs = Gdx.app.getPreferences("prefs");
    if (prefs.getBoolean("newInstall", false)) {
        for (String file : filesToCopy) {
            final FileHandle handle = Gdx.files.local(file);
            // copy to handle
        }
    }
    prefs.putBoolean("newInstall", true);
    prefs.flush();
}