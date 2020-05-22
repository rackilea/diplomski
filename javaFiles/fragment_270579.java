final DateFormat dateFormat = DateFormat.getDateInstance() ; // or whatever format object you need...
geboortedatum.setCellFactory(col -> new TableCell<Persoon, Calendar>() {
    @Override
    public void updateItem(Calendar item, boolean empty) {
        super.updateItem(item, empty);
        if (item == null) {
            setText(null);
        } else {
            setText(dateFormat.format(item.getTime()));
        }
    }
});