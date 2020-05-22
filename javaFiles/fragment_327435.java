JFileChooser chooser = new JFileChooser();

FileNameExtensionFilter filter = new FileNameExtensionFilter("JPG & GIF Images", 
                                                                        "jpg", "gif");
chooser.setFileFilter(filter);
int retval = chooser.showDialog(chooser, "Save");

// etc