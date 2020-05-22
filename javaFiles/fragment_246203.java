@Test
    public void test() throws Exception {

        @SuppressWarnings("unchecked")
        ListView<TableRowDisplayCodes> lvSelected = spy(ListView.class);

        codesList = FXCollections.observableArrayList();
        selectedList = FXCollections.observableArrayList();
        lvSelected.setItems(selectedList);

        selectedList.add(new TableRowDisplayCodes(UOItems.UO_03));
        invokeMethod(cpc, "addListItem", lvSelected, new TableRowDisplayCodes(UOItems.UO_04), MAX_OU_ITEMS);
        assertEquals(2, lvSelected.getItems().size());
    }