public class ClassOGP extends JFrame{
    /* other code */

    public GraphicsDevice device;

    public ClassOGP(String title,int width,int height) {
        if(GraphicsEnvironment.getLocalGraphicsEnvironment().getScreenDevices().length() > 0) {
            // you can also check for multiple devices here to see if you want
            // to use one other than the zero'th index
            device = GraphicsEnvironment.getLocalGraphicsEnvironment().getScreenDevices()[0];
        } else {
            System.out.println("ERROR: No devices ... exiting.");
            System.exit();
        }

        /* other code */
    }

    /* rest of class */
}