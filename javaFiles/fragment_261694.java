binder.registerCustomEditor(Date.class, new PropertyEditorSupport() {
    public void setAsText(String value) {
        try {
            setValue(new SimpleDateFormat("dd/MM/yyyy").parse(value));
        } catch(ParseException e) {
            setValue(null);
        }
    }

    public String getAsText() {
        return new SimpleDateFormat("dd/MM/yyyy").format((Date) getValue());
    }        

});