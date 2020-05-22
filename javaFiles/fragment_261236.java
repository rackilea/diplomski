SpinnerDateModel model = new SpinnerDateModel();
JSpinner spinner = new JSpinner(model);

JSpinner.DateEditor editor = new JSpinner.DateEditor(spinner, "dd.MM.yyyy");
DateFormatter formatter = (DateFormatter)editor.getTextField().getFormatter();
formatter.setAllowsInvalid(false); // this makes what you want
formatter.setOverwriteMode(true);