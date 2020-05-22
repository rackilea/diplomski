File myFilename;
chooser = new JFileChooser();
chooser.addChoosableFileFilter(new OpenFileFilter("jpeg","Photo in JPEG format") );
chooser.addChoosableFileFilter(new OpenFileFilter("jpg","Photo in JPEG format") );
chooser.addChoosableFileFilter(new OpenFileFilter("png","PNG image") );
chooser.addChoosableFileFilter(new OpenFileFilter("svg","Scalable Vector Graphic") );
int returnVal = chooser.showSaveDialog(mainWindow);
if (returnVal == JFileChooser.APPROVE_OPTION) {
     myFilename = chooser.getSelectedFile();
     //do something with the file
}