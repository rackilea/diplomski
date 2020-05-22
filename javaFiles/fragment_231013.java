// No password result starting a second activity.
public void testNoPassword() {
  // register NewPasswordActivity that need to be monitored.
  ActivityMonitor activityMonitor = getInstrumentation().addMonitor(NewPasswordActivity.class.getName(), null, false);

  // Get current activity, it will start NewPasswordActivity in consequence.
  PasswordEntryActivity currentActivity = getActivity();

  NewPasswordActivity nextActivity = getInstrumentation().waitForMonitorWithTimeout(activityMonitor, 5);
  // NewPasswordActivity is opened and captured.
  assertNotNull(nextActivity);
  // Don't forget to release/finish NewPasswordActivity after test finish.
  nextActivity.finish();
}