//Convert Enumeration to a List
List<AbstractButton> listRadioButton = Collections.list(group.getElements());

//show the list of JRadioButton
for (AbstractButton button : listRadioButton) {
    System.out.println("Next element : " + ((JRadioButton) button).getText());
    System.out.println("Is selectd = " + button.isSelected());
}

//Set the first JRadioButton selected
if(listRadioButton.size() > 0){
    listRadioButton.get(0).setSelected(true);
}