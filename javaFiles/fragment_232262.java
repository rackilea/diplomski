ObjectProperty<File> bgmFile = new SimpleObjectProperty(this, "bgmFile", null);
StringBinding fileName = Bindings.createStringBinding( () -> {
    File file = bgmFile.get();
    if (file != null && file.exists()) {
        return file.getName();
    } else return "[NONE]";
}, bgmFile);