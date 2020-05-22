// Instance(?) field here...
Hini = new javax.swing.JSpinner();
Date date = new Date();
SpinnerDateModel sm = new SpinnerDateModel(date, null, null, Calendar.MINUTE);
// Local field here
JSpinner Hini = new JSpinner(sm);
JSpinner.DateEditor de = new JSpinner.DateEditor(Hini, "hh:mm a");
de.getTextField().setEditable( true );
Hini.setEditor(de);