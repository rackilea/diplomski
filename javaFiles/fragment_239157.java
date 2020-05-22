public void printSelectedNames(JCheckBox[] boxes) {

    for(JCheckBox box : boxes)
        if(box.isSelected())
            System.out.println(box.getText());
}