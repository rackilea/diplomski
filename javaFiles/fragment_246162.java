public DatePicker getDatePicker(DtDate defaultDate, int width){
    DatePicker dtpckr = new DatePicker();
    dtpckr.setMaxWidth(width);
    dtpckr.setMinWidth(width);
    dtpckr.setConverter(new StringConverter<LocalDate>() {
        private DateTimeFormatter dateTimeFormatter=DateTimeFormatter.ofPattern("yyyy/MM/dd");
        @Override
        public String toString(LocalDate localDate) {
            if(localDate==null)
                return "";
            return dateTimeFormatter.format(localDate);
        }
        @Override
        public LocalDate fromString(String dateString) {
            if(dateString==null || dateString.trim().isEmpty())
                return null;
            try{
                return LocalDate.parse(dateString,dateTimeFormatter);
            }
            catch(Exception e){
                //Bad date value entered
                return null;
            }
        }
    });
    dtpckr.setPromptText("yyyy/MM/dd");
    dtpckr.setValue(LocalDate.parse(defaultDate.toString(), DateTimeFormatter.ofPattern("yyyy/MM/dd")));
    //This deals with the bug located here where the datepicker value is not updated on focus lost
    //https://bugs.openjdk.java.net/browse/JDK-8092295?page=com.atlassian.jira.plugin.system.issuetabpanels:all-tabpanel
    dtpckr.focusedProperty().addListener(new ChangeListener<Boolean>() {
        @Override
        public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
            if (!newValue){
                dtpckr.setValue(dtpckr.getConverter().fromString(dtpckr.getEditor().getText()));
            }
        }
    });
    return dtpckr;
}