public void waitViewShown(Matcher<View> matcher) {
    IdlingResource idlingResource = new ViewShownIdlingResource(matcher);///
    try {
        IdlingRegistry.getInstance().register(idlingResource);
        onView(matcher).check(matches(isDisplayed()));  
    } finally {
        IdlingRegistry.getInstance().unregister(idlingResource);
    }    
}