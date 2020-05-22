import ij.IJ;
import ij.ImagePlus;
import ij.measure.Measurements;
import ij.plugin.Thresholder;
import ij.plugin.filter.PlugInFilter;
import ij.process.ImageProcessor;

public class CASA_ implements PlugInFilter,Measurements  {
    // define instance variables:
    ImagePlus imp;

    /**
     * implement interface methods
     */
    public int setup(String arg, ImagePlus imp) {
        this.imp = imp;
        Thresholder.setMethod("Mean");
        IJ.log("Setup done.");
        return DOES_ALL;
    }

    public void run(ImageProcessor ip) {
        // do your processing here
    }
}