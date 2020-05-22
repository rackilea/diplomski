public class UIUtils {

    UIUtils singleton;

    private UIUtils{} //Don't instantiate this class publicly

    public static UIUtils getInstance() {
        if(singleton==null) //This is the first time the method is called
             singleton = new UIUtils();
        return singleton; //Return the one instance of UIUtils
    }

    public void fadeComponent(JComponent toFade) {
        //Fade code goes here
    }

    //Other utility methods
}