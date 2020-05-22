JFrame frame=new JFrame();
JFileChooser filechooser = new JFileChooser();
FileFilter filter = new FileNameExtensionFilter("EXE File","exe");
filechooser.setFileFilter(filter);
filechooser.showOpenDialog(frame);
File file = filechooser.getSelectedFile();
System.out.println("YOU CHOOSE "+file.getAbsolutePath());