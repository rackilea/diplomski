public class ClassUsingJoysticksTest {
    @Mocked Joystick joystick1;
    @Mocked Joystick joystick2;

    @Before
    public void setUp() {
        new Expectations() {
            new Joystick(0);
            result = joystick1;

            new Joystick(1);
            result = joystick2;
        }
    }

    @Test
    public void testRumbles() {
        classThatUsesJoysticks.doSomething();

        new Verifications() {{
             joystick1.setRumble(1.0);
             joystick2.setRumble(1.0);
        }};
    }
}