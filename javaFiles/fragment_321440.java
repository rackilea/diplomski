import java.applet.Applet;

public class GfxApplet extends Applet {

    @Override
    public void init() {
        super.init();
        GfxApp app = new GfxApp();
        add(app);
    }

}