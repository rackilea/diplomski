// Get the current transform 
AffineTransform saveAT = g2.getTransform(); 
// Perform transformation 
g2d.transform(...); 
// Render 
g2d.draw(...); 
// Restore original transform 
g2d.setTransform(saveAT);