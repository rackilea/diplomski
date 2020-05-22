@RunWith(AndroidJUnit4.class)
public class SomeClass {
.... some setup and stuff...

    @Test
    public void testCoordinates() {
        UiDevice device = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation());
        device.click(42, 242);
    }
}