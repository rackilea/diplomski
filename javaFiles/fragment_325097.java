import ij.*;
import ij.process.*;
import ij.gui.*;
import java.awt.*;
import ij.plugin.*;
import ij.plugin.frame.*;

public class My_Plugin implements PlugIn {

    public void run(String arg) {
        ImagePlus imp = IJ.openImage("http://imagej.nih.gov/ij/images/blobs.gif");
        IJ.run(imp, "Set Scale...", "distance=1 known=2 pixel=1 unit=um");
        IJ.run(imp, "Scale Bar...", "width=50 height=3 font=12 color=Black background=None location=[Upper right]");
        imp.show();
    }

}