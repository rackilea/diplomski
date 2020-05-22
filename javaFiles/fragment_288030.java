@Rule
public ActivityTestRule<MainActivity> mMainActivity =
        new ActivityTestRule(MainActivity.class, false, true);

private IdlingResource mIdlingResource;

@Before
public void registerIdlingResource() {
    mIdlingResource = mMainActivity.getActivity().getIdlingResource();
    IdlingRegistry.getInstance().register(mIdlingResource);
    mMainActivity.launchActivity(new Intent());
}