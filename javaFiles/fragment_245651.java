import android.support.test.espresso.contrib.RecyclerViewActions;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

@RunWith(AndroidJUnit4.class)
public class TestIngredients {

    /** the Activity of the Target application */
    private IngredientsActivity mActivity;

    /** the {@link RecyclerView}'s resource id */
    private int resId = R.id.recyclerview_ingredients;

    /** the {@link RecyclerView} */
    private IngredientsLinearView mRecyclerView;

    /** and it's item count */
    private int itemCount = 0;

    /**
     * such a {@link ActivityTestRule} can be used eg. for Intent.putExtra(),
     * alike one would pass command-line arguments to regular run configurations.
     * this code runs before the {@link FragmentActivity} is being started.
     * there also would be an {@link IntentsTestRule}, but not required here.
    **/
    @Rule
    public ActivityTestRule<IngredientsActivity> mActivityRule = new ActivityTestRule<IngredientsActivity>(IngredientsActivity.class) {

        @Override
        protected Intent getActivityIntent() {
            Intent intent = new Intent();
            Bundle extras = new Bundle();
            intent.putExtras(extras);
            return intent;
        }
    };

    @Before
    public void setUpTest() {

        /* obtaining the Activity from the ActivityTestRule */
        this.mActivity = this.mActivityRule.getActivity();

        /* obtaining handles to the Ui of the Activity */
        this.mRecyclerView = this.mActivity.findViewById(this.resId);
        this.itemCount = this.mRecyclerView.getAdapter().getItemCount();
    }

    @Test
    public void RecyclerViewTest() {
        if(this.itemCount > 0) {
            for(int i=0; i < this.itemCount; i++) {

                /* clicking the item */
                onView(withId(this.resId))
                  .perform(RecyclerViewActions.actionOnItemAtPosition(i, click()));

                /* check if the ViewHolder is being displayed */
                onView(new RecyclerViewMatcher(this.resId)
                  .atPositionOnView(i, R.id.cardview))
                  .check(matches(isDisplayed()));

                /* checking for the text of the first one item */
                if(i == 0) {
                    onView(new RecyclerViewMatcher(this.resId)
                      .atPositionOnView(i, R.id.ingredientName))
                      .check(matches(withText("Farbstoffe")));
                }

            }
        }
    }
}