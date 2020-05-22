final int index = counter;
    gradeField[counter].addActionListener(new ActionListener () {
        @Override
        public void actionPerformed(ActionEvent e) {
            Object holder = e.getSource();
            JComboBox tempGradeBox = (JComboBox)holder;
            String theGrade = (String)tempGradeBox.getSelectedItem();
            grade.userGrades[index] = theGrade;
        }                       
    });