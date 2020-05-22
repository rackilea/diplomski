public static List<String> manageCheckedCheckboxes(final Container c) {
    Component[] comps = c.getComponents();
    List<String> checkedTexts = new ArrayList<String>();

    for (Component comp : comps) {

        if (comp instanceof JCheckBox) {
            JCheckBox box = (JCheckBox) comp;
            if (box.isSelected()) {

                String text = box.getText();
                checkedTexts.add(text);
            }
        }
    }

    return checkedTexts;

}