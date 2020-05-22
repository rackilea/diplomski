public static ViewAction forceClick() {
    return new ViewAction() {
        @Override public Matcher<View> getConstraints() {
            return allOf(isClickable(), isEnabled());
        }

        @Override public String getDescription() {
            return "force click";
        }

        @Override public void perform(UiController uiController, View view) {
            view.performClick();
            uiController.loopMainThreadUntilIdle();
        }
    };
}