class MyFileHandleResolver implements FileHandleResolver {
    public FileHandle resolve(String fileName) {
        FileHandle localHandle = Gdx.files.local(fileName);
        if (localHandle.exists())
            return localHandle;
        else
            return Gdx.files.internal(fileName);    
    }
}