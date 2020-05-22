comboBox.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {

        //Changes top label to name of the program selected
        lblProgramName.setText((String) comboBox.getSelectedItem()); 
        //Changes path name to the name of the selected program
        xPath = (String) comboBox.getSelectedItem(); 
        pathChanged = true; // Tells comboBoxes the path has changed
        System.out.println(xPath); // Just testing path name
        //////////////////Move code here////////////////////////////////
    }
});