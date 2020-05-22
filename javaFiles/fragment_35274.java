testCat_tbl.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Patienttabledetails, String>>()

    {
        @Override
        public void handle(TableColumn.CellEditEvent<Patienttabledetails, String> event) {
            System.out.println("Value"+event.getNewValue());

            // TODO: replace setter name by suitable setter of your Patienttabledetails class here
            event.getRowValue().setSomeProperty(event.getNewValue());
        }
    });