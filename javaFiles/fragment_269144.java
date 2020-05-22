JComboBox<String> myComobBox = new JComboBox<String>();
JButton myButton =  new JButton("jButton");
myComboBox.addItem("6.A.M");
// Add button listener
myButton.addActionListener(e -> {
    // Use getSelectedItem instead of getText
    if(((String) myComboBox.getSelectedItem) == "6.A.M") {
         SixAMRoute sam = new SixAMRoute();
         sam.setVisible(true);
         this.dispose();
    }
});