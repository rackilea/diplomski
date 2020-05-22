private void pnl1submitbtnActionPerformed(java.awt.event.ActionEvent evt {                                         
    moduleFunc moduleFunc;
    String module = moduletxtfield.getText();
    double exam = 0, ct = 0, quiz = 0, assign = 0;
    if(examtextfield.isEnabled())
        exam = Double.parseDouble(examtextfield.getText());
    if(cttextfield.isEnabled())
        ct = Double.parseDouble(cttextfield.getText());
    if(quiztextfield.isEnabled())
        quiz = Double.parseDouble(quiztextfield.getText());
    if(asstextfield.isEnabled())
        assign = Double.parseDouble(asstextfield.getText());
    try {
        if (module.trim().isEmpty()) {
            moduleerrorlbl.setText("Field cannot be empty");
        }
        else if (!(exam+ct+quiz+assign == 100)) {
            markerrorlbl.setText("Total marks must be 100");
        }
        else
        {
            markerrorlbl.setText("");
            moduleerrorlbl.setText("");
        }
    }
    //do whatever you want with your double values.
}