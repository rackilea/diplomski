public class MainApplet extends LwjglApplet {
    public static final long serialVersionUID = 1L;

    public final SaveState saver = new AppletSaveState();

    public MainApplet() {
       super(new TitansArena(saver), false);
       saver.appletContext = this; // fixup saver instance to point necessary context
    }
}