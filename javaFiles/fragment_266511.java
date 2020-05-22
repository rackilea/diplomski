/**
 * This number represents maximum size of an image ( x*y )
 * So this value cover up to 300% zoom for an image 1000x1000 pixels
 */
public static final String MAX_PIXELS_NUMBER = "10000000";   

static {
        try {
            JRProperties.setProperty(JRViewer.VIEWER_RENDER_BUFFER_MAX_SIZE, MAX_PIXELS_NUMBER);
        } catch (Exception e) {
            System.err.println("Cannot set the VIEWER_RENDER_BUFFER_MAX_SIZE property. Reports will be rendered slowly.");
        }
    }