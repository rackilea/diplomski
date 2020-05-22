//You could use a factory pattern to make this a singleton instead of having static methods
public abstract class UIUtils {

    private UIUtils{} //Don't instantiate this class

    public static void fadeComponent(JComponent toFade) {
        //Fade code goes here
    }

    //Other static utility methods
}