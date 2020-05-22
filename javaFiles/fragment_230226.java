// initialize it as read-only and drop-down
Combo readOnlyCombo = new Combo(parent, SWT.DROP_DOWN | SWT.READ_ONLY);
// set the item array as the item source
readOnlyCombo.setItems(YOUR_ENTRIES);
// set the desired index to be selected as the default selection (index 0 is the first item)
readOnlyCombo.select(0);