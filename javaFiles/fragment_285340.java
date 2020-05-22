import ij.ImagePlus;
import ij.plugin.ImageCalculator;

[...]

ImageCalculator ic = new ImageCalculator();
ImagePlus imp3 = ic.run("AND create", imp1, imp2);