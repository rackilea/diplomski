myColumn.setFieldUpdater(new FieldUpdater() {

    @Override
    public void update(int index, MyDTO object, String value) {
        // Push the changes into the MyDTO. At this point, you could send an
        // asynchronous request to the server to update the database.
        object.someField = value;

        // Redraw the table with the new data.
        table.redraw();
    }
});