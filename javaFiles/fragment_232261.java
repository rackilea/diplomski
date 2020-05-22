new SimpleObjectProperty<File>(this, "BGM File", null){

    final StringBinding string = Bindings.createStringBinding(() -> {
        File file = this.get();
        if (file != null && file.exists()) {
            return file.getName();
        } else {
            return "[NONE]";
        }
    }, this);

    @Override public StringBinding asString(){
        return string ;
    }
}