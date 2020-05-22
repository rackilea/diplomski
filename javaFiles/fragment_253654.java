@Override
public void widgetSelected(SelectionEvent e) {
    //how to know in which row is clicked the checkbox?
    System.out.println("Row selected: " + membersTable.indexOf(tableItem));
    System.out.println("Participación Habitual: " + tableItem.getText(2));
}