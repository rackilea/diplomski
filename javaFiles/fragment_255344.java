Display display = new Display();
Shell shell = new Shell(display);
shell.setLayout(new GridLayout());
Label label = new Label(shell, SWT.NONE);
label.setText("I am italic");
FontData fontData = label.getFont().getFontData()[0];
Font font = new Font(display, new FontData(fontData.getName(), fontData
    .getHeight(), SWT.ITALIC));
label.setFont(font);
shell.open();
while (!shell.isDisposed()) {
  if (!display.readAndDispatch())
    display.sleep();
}
font.dispose();
display.dispose();