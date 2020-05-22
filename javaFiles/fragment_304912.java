JButton btnNewButton = new JButton("New button");
btnNewButton.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent arg0) {
        System.out.println(checkBoxes.size());
        for (int i = 0; i < checkBoxes.size(); i++) {
            if (checkBoxes.get(i).isSelected()) {
                System.out.println(" Checkbox " + i + " and " + checkBoxes.get(i).getText() + " is selected");
            } else {
                System.out.println(
                        " Checkbox " + i + " and " + checkBoxes.get(i).getText() + " is noooooot selected");
            }
        }
    }

});