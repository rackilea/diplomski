public class CanFillInABasicFormTest extends UISpecTestCase {
    public void setUp() {
        setAdapter(new MainClassAdapter(Main.class, new String[0]));
    }

    public void test() {
        Window mainWindow = getMainWindow();
    }
}