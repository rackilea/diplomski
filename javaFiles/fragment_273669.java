public void commit(Object val) {

        // Get the table
        TableView<S> t = this.getTableView();

        // Get the selected row/column
        S selectedRow = t.getItems().get(this.getTableRow().getIndex());
        TableColumn<S, ?> selectedColumn = t.getColumns().get(t.getColumns().indexOf(this.getTableColumn()));

        // Get current property name
        String propertyName = ((PropertyValueFactory) selectedColumn.getCellValueFactory()).getProperty();

        // Create a method name conforming to java standards ( setProperty )
        propertyName = ("" + propertyName.charAt(0)).toUpperCase() + propertyName.substring(1);

        // Try to run the update
        try {

            // Type specific checks - could be done inside each setProperty() method
            if(val instanceof Double) {
                Method method = selectedRow.getClass().getMethod("set" + propertyName, double.class);
                method.invoke(selectedRow, (double) val);
            }
            if(val instanceof String) {
                Method method = selectedRow.getClass().getMethod("set" + propertyName, String.class);
                method.invoke(selectedRow, (String) val);
            }
            if(val instanceof Integer) {
                Method method = selectedRow.getClass().getMethod("set" + propertyName, int.class);
                method.invoke(selectedRow, (int) val);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        // CommitEdit for good luck
        commitEdit((T) val);
    }