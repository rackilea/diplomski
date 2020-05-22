public class SongFile {

    AssetManager manager;
    Music music;

    public SongFile(FileHandle file){
        manager = new AssetManager(new ExternalFileHandleResolver());
        if (file.exists()) {
            manager.load(file.path(), Music.class);
            manager.finishLoading();
            music = manager.get(file.path(), Music.class);
            music.setLooping(true);
            music.play();
        }
    }

    ...
}