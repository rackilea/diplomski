JFrame frame = new JFrame("frame");
InputSpinner spinner = new InputSpinner("spinner");

frame.add(spinner.getComponent());

spinner.setValue(5.1); 
spinner.setMinimum(1.0); 
spinner.setMaximum(25.3);  
spinner.setStepSize(2.5);

frame.pack();
frame.setVisible(true);