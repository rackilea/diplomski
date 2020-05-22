public class MyAccessibility extends AccessibilityService {

public static MyAccessibility instance;

@Override
    protected void onServiceConnected() {
        super.onServiceConnected();

        System.out.println("Accessibility was connected!");

        instance = this;

    }

    public void doAction(){

    performGlobalAction(GLOBAL_ACTION_RECENTS);

    }

}