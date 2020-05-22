JDialog dialog = JColorChooser.createDialog(
    frame.getContentPane(),
    "Choose a Color",
    true,
    cc,
    null,
    null);
dialog.setVisible(true);
System.out.println( cc.getColor() );