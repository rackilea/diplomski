JFileChooser chooser = new JFileChooser();
chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
int returnVal = chooser.showOpenDialog(parent);
if (returnVal == JFileChooser.APPROVE_OPTION)
{
System.out.println("You chose to open this directory: " + chooser.getSelectedFile().getAbsolutePath());
}