//sometime on initalization of the lists
for(CustomTextField field: listA):
    field.getDocument().putProperty("owner", field);

...

@Override
public void insertUpdate(DocumentEvent e) {
    try {
        CustomTextField field = e.getDocument().getProperty("owner");
        int index = field.getIndex(); //assuming you have a getter method
        listB().get(index).setText(listA.get(index).getText());

    } catch (BadLocationException e1) {
        e1.printStackTrace();
    }

}