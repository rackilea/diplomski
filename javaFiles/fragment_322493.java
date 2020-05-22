JButton continueButton = new JButton("Continue");
continueButton.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent a) {
        if(continueButton.isEnabled()){

            Student studentScreen = new Student();
            studentScreen.dispose();

            AddGrades addGradesScreen = new AddGrades(studentNameTextField.getText());
            addGradesScreen.setVisible(true);
        }
    }
});