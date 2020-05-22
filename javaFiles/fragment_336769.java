import ij.IJ;
import ij.ImagePlus;
import ij.io.FileSaver;
import ij.plugin.PlugIn;


public class Test implements PlugIn {

public static void main(String[] args) {

    Test test = new Test();
    test.run("Denoise.ijm");

}

@Override
public void run(String arg0) {
    String directory = "C:\\Users\\Speedy Octopus\\Desktop\\10Cover Shots\\10.JPG";

    ImagePlus imp = IJ.openImage(directory);
    FileSaver fileSaver = new FileSaver(imp);

    System.setProperty("plugins.dir", "C:\\Users\\Speedy Octopus\\Downloads\\ij150-win-java8\\ImageJ\\plugins");
    IJ.run(imp, "Non-local Means Denoising", "sigma=5 smoothing_factor=1");
    fileSaver.saveAsJpeg("C:\\Users\\Speedy Octopus\\Desktop\\10Cover Shots\\10edited.JPG");
}
}