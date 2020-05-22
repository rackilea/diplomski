if(comboBox.getSelectedItem().equals("-"))
{
    label.SetTest("No Item is Selected");
}
else if(comboBox.getSelectedIndex() > 0)
    label.SetText(comboBox.getSelectedItem());