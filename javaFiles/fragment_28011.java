if(Gdx.app.type==Application.ApplicationType.Android) {

     var assetManager = AssetManager(ExternalFileHandleResolver())
     var fileHandle = Gdx.files.external("/Download/WorldmapTheme.mp3")

     if (fileHandle.exists()) {

        assetManager.load(fileHandle.path(), Music::class.java)
        assetManager.finishLoading();

        var music = assetManager.get<Music>(fileHandle.path())
        music.setLooping(true)
        music.play()
     }
}