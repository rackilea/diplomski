JXTable table = new JXTable(0, 2);
DefaultComboBoxModel persons = new DefaultComboBoxModel(
        new PersonObject[] { new PersonObject("first", "last"),
                new PersonObject("first2", "last2"),
                new PersonObject("first3", "last3"), });
JXList list = new JXList(persons);
PersonTransferHandler handler = new PersonTransferHandler();
list.setTransferHandler(handler);
list.setDragEnabled(true);
table.setTransferHandler(handler);
showWithScrollingInFrame(table, list, "custom dnd");