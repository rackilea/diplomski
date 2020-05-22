import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;

public class Test {

    public static void main(String[] args) {
        GraphicsEnvironment ge
                = GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice gd = ge.getDefaultScreenDevice();

        boolean isUniformTranslucencySupported
                = gd.isWindowTranslucencySupported(GraphicsDevice.WindowTranslucency.TRANSLUCENT);
        boolean isPerPixelTranslucencySupported
                = gd.isWindowTranslucencySupported(GraphicsDevice.WindowTranslucency.PERPIXEL_TRANSLUCENT);
        boolean isShapedWindowSupported
                = gd.isWindowTranslucencySupported(GraphicsDevice.WindowTranslucency.PERPIXEL_TRANSPARENT);

        System.out.println("isUniformTranslucencySupported = " + isUniformTranslucencySupported);
        System.out.println("isPerPixelTranslucencySupported = " + isPerPixelTranslucencySupported);
        System.out.println("isShapedWindowSupported = " + isShapedWindowSupported);
    }

}