// LOOP

// loop through all elements in the list
for (int i=0; i<listmodel.size(); i++) {

    // get the listitem associated with the current element
    final Object object = listmodel.get(i);
    if (object instanceof ListItem) {
        ListItem listitem = (ListItem) object;

        // use getText() to get the text asociated with the listitem
        System.out.print(listitem.getText());

        // test if the current item is selected or not
        if (list.isSelectedIndex(i)) {
            System.out.print(" (selected)");
        }

        // next
        System.out.println();
    }
}

// CHANGE NAME + ICON

// create a new list item
ListItem itemNew = new ListItem("/resources/icnNew.png", "Element 3");

// replaced the first item in the list with the new one
listmodel.set(0, itemNew);