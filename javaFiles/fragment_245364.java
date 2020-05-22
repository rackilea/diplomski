@RunWith(AndroidJUnit4.class)
@SmallTest
public class BaseActivityTest {
    @Rule
    public ActivityTestRule<TestActivity> mTestActivityActivityTestRule = new ActivityTestRule<TestActivity>(TestActivity.class, true, false);
    @Before
    public void set() {
        //setup your things
    }
    @Test
    public void testRequest1() {
        mTestActivityActivityTestRule.launchActivity(new Intent());
    }
}