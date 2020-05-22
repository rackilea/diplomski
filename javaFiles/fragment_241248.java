String exportFile = "pptx/export.pptx";
XSLFSlide[] slides = ppt.getSlides();
XSLFSlide slide = slides[0];
int x=300;
int y=400;
int R=50;
double kappa = 0.5522847498;
java.awt.geom.GeneralPath circle = new java.awt.geom.GeneralPath();
circle.moveTo(x, y-R); // move to A
circle.curveTo(x+R*kappa, y-R, x+R, y-R*kappa, x+R, y); // curve to A', B', B
circle.curveTo(x+R, y+R*kappa, x+R*kappa, y+R, x, y+R );
circle.curveTo(x-R*kappa, y+R, x-R, y+R*kappa, x-R, y);
circle.curveTo(x-R, y-R*kappa, x-R*kappa, y-R, x, y-R );
circle.closePath();
XSLFFreeformShape shape5 = slide.createFreeform();
shape5.setPath(circle);
shape5.setLineWidth(3);
shape5.setLineColor(Color.ORANGE);

// creating a file object
File file = new File(exportFile);
FileOutputStream out = new FileOutputStream(file);
// saving the changes to a file
ppt.write(out);
out.close();