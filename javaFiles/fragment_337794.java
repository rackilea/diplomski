import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner;
import androidx.test.rule.ActivityTestRule;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.RootMatchers.withDecorView;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.not;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

@RunWith(AndroidJUnit4ClassRunner.class)
public class ExampleAndroidTest {

    @Rule
    public ActivityTestRule<Main2Activity> mActivityRule =
            new ActivityTestRule<>(Main2Activity.class);

    @Test
    public void buttonClickShowingToast_isCorrect() {
        onView(withId(R.id.bt_test)).perform(click());
        onView(withText(R.string.toast_test))
            .inRoot(withDecorView(not(
                    mActivityRule.getActivity().getWindow().getDecorView()
            ))).check(matches(isDisplayed()));
}
}