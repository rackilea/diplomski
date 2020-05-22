ComboBox<Locale> languages = new ComboBox<>();
languages.getItems().addAll(new Locale("en"), new Locale("fr"), new Locale("fi"), new Locale("ru"));
languages.setConverter(new StringConverter<Locale>() {
    @Override
    public String toString(Locale l) {
        return l.getDisplayLanguage(l);
    }
    @Override
    public Locale fromString(String s) {
        // only really needed if combo box is editable
        return Locale.forLanguageTag(s);
    }
});

Utils.localeProperty().bind(languages.valueProperty());