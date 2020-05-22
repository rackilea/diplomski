Date date = new Date();
SpinnerDateModel sm = new SpinnerDateModel(date, null, null, Calendar.MINUTE);

JSpinner spinner = new JSpinner(sm);
JSpinner.DateEditor de = new JSpinner.DateEditor(spinner, "hh:mm a");
de.getTextField().setEditable( false );
spinner.setEditor(de);

System.out.println("Spinner:      "+de.getFormat().format(spinner.getValue()));