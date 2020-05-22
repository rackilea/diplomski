FileHandle dirHandle;
if (Gdx.app.getType() == ApplicationType.Android) {
   dirHandle = Gdx.files.internal("some/directory");
} else {
  // ApplicationType.Desktop ..
  dirHandle = Gdx.files.internal("./bin/some/directory");
}
for (FileHandle entry: dirHandle.list()) {
   // yadda ...
}