int welcome;

      // store the output result of showConfirmDialog in welcome

      welcome=JOptionPane.showConfirmDialog(null, "Woild you like to input grades on the students?",
                "Grade",JOptionPane.YES_NO_OPTION);

      // compare result with predefined positive value i.e JOptionPane.YES_OPTION
     if (welcome == JOptionPane.YES_OPTION){