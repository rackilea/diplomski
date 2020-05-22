public void actionPerformed(ActionEvent e) {

    if (e.getSource() instanceof JCheckBox) {

        JCheckBox checkBox = (JCheckBox)e.getSource();
        String text = checkBox.getText();

        int pos = ta.getText().getLength()
        ta.insert(text, pos);

        // or, more simply

        ta.append(text);


    }

}