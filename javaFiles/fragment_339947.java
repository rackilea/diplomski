JDialog dialog = new JDialog();
JPanel reallyComplexPanel = new JPanel(new BorderLayout());
// add in stuff here, e.g buttons at the bottom
Something mySomething = new Something();
reallyComplexPanel .add(mySomething, BorderLayout.NORTH);  // my stuff at the top
dialog.setContentPane(reallyComplexPanel);