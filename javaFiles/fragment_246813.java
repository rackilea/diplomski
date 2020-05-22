class YourClass {
    ImagePlus imp;

    public void openImage( String imageFilepath ) {
        if ( imp == null {
            imp = IJ.openImage(imageFilepath);  
        }
        else {
           // Reuse
           ImagePlus imp2 = IJ.openImage(imageFilepath);
           imp.setImage(imp2) 
        }
        imp.show();  
    }
}