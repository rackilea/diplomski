//Launch ImageJ in NO_SHOW mode: Run embedded and invisible in another application.
ImageJ imageJApplication = new ImageJ(2);

Opener opener = new Opener();  
String imageFilePath = "path/to/your/image.png";
ImagePlus imp = opener.openImage(imageFilePath);
imp.show();
IJ.runPlugIn("ij.plugin.Zoom", null);