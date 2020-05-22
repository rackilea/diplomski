// get the FilePane Component of JFileChooser
Object filepane = fc.getComponent(2);
// get the list field with reflection
Field field_list = filepane.getClass().getDeclaredField("list");
// get access to this private field
field_list.setAccessible(true);
// read the value of the field
JList<?> list = (JList<?>)field_list.get(filepane);
// change the layout orientation
list.setLayoutOrientation(JList.VERTICAL);