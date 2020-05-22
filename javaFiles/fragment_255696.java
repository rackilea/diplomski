private void periodicRefresh() {
// Logout if requested
if (mKicker != null) {
    String kickMessage = KickoutMessageText + mKicker.getData().getName();
    mKicker = null;
    logoutCore();
    Notification.show(KickoutMessageTitle, kickMessage, Notification.TYPE_WARNING_MESSAGE);
}

// Refresh logged in users
refreshLoggedInUsers();

// Refresh GPIO pin states
refreshGPIOPinStates();