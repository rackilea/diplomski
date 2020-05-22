@get:Rule
    val intentRule = IntentsTestRule(MainActivity::class.java)

    @Test
    fun verify_FakeActivity_is_started() {
        onView(withId(R.id.button))
            .check(matches(isDisplayed()))
            .check(matches(isEnabled()))
            .perform(click())

        intended(hasComponent(FakeActivity::class.java.name))
    }