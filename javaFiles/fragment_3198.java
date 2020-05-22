DatePicker datePicker=new DatePicker();
datePicker.setValue(LocalDate.now());
datePicker.setConverter(new StringConverter<LocalDate>() {

    @Override
    public String toString(LocalDate object) {
        return object.format(defaultFormatter);
    }

    @Override
    public LocalDate fromString(String string) {
        try{
            return LocalDate.parse(string, fastFormatter);
        } catch(DateTimeParseException dtp){}

        return LocalDate.parse(string, defaultFormatter);
    }
});