public class vmHelp {
public static void main(String args[]) {
    JHelp helpViewer = null;
    String title = "";
    try {
        // Get the classloader of this class.                                                                                                                                                             
        ClassLoader cl = vmHelp.class.getClassLoader();
        // Use the findHelpSet method of HelpSet to create a URL referencing the helpset file.                                                                                                            
        // Note that in this example the location of the helpset is implied as being in the same                                                                                                          
        // directory as the program by specifying "jhelpset.hs" without any directory prefix,                                                                                                             
        // this should be adjusted to suit the implementation.                                                                                                                                            
        String lHelpSetFile = "APP.hs";
        URL url = HelpSet.findHelpSet(cl, lHelpSetFile);
        if (url == null) {
            System.err.println("URL is null, maybe the help set file is wrong: " + lHelpSetFile + ". Look at vmHelp.java");
            return;
        }
        // Create a new JHelp object with a new HelpSet.                                                                                                                                                  
        HelpSet h = new HelpSet(cl, url);
        title = h.getTitle();
        helpViewer = new JHelp(h);
        // Set the initial entry point in the table of contents.                                                                                                                                          
        helpViewer.setCurrentID("top");
    } catch (Exception e) {
        System.err.println(e.getMessage());
    }

    // Create a new frame.                                                                                                                                                                                
    JFrame frame = new JFrame();
    // Set it's size.                                                                                                                                                                                     
    frame.setSize(1000, 800);
    // Add the created helpViewer to it.                                                                                                                                                                  
    frame.getContentPane().add(helpViewer);
    // Set a default close operation.                                                                                                                                                                     
    frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    frame.setTitle(title);

    // Make the frame visible.                                                                                                                                                                            
    frame.setVisible(true);
}