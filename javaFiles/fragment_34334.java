Combo box = new Combo(parent, SWT.DROP_DOWN);
String s = "Item 1";
box.add(s);
box.setData(s, "Some other info or object here");
s = "Item 2";
box.add(s);
box.setData(s, "This is item two");

String value = (String)box.getData("Item 2");
// value is now "This is item two"