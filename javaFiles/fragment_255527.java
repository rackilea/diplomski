update_column_cell.addClickHandler(new ClickHandler() {
    @Override
    public void onClick(ClickEvent event) {
         //Supose listDataProvider is the instance of your DataSource for your CellTable
         List<MyDTO> list = listDataProvider.getList();
         // get cell values for the first row (this is for one cell)
         newSomeField = list.get(0).someField;
         newSomeField2 = list.get(0).someField2;
         for (int i = 1;i<list.size();i++) {
              MyDTO dto = list.get(i);
              if (newSomeField != null && newSomeField.isNotEmpty()) {
                    dto.someField = newSomeField;
              }
              if (newSomeField2 != null && newSomeField2.isNotEmpty()) {
                    dto.someField2  = newSomeField2;
              }
         }
    }
})