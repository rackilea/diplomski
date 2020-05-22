@Override
public void create() {
    ...
    for (String file : filesToCopy) {
        final FileHandle handle = Gdx.files.local(file);
        if (!handle.exists()) {
            // copy to handle
        }
    }
}