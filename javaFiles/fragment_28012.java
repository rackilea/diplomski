if(Gdx.app.getType()== Application.ApplicationType.Android) {
    String file = "/download/prueba.mp3";
    FileHandle fileHandle = Gdx.files.external(file);
    SongFile songFile = new SongFile(fileHandle);
    songFile.parse();
    song = songFile.makeSong();
}