import ij.IJ;
import ij.ImagePlus;

[...]

ImagePlus imp = // you have to know how to get your image
IJ.run(imp, "Analyze Particles...", "size=500-Infinity circularity=0.00-1.00 show=Masks in_situ");