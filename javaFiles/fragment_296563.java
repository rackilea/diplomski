void requestPublishPermissions() {
    Log.d(TAG, "Requesting publish permissions.");
    final Session session = Session.getActiveSession();
    if (session != null) {
        Session.NewPermissionsRequest newPermissionsRequest = new      Session.NewPermissionsRequest(
                this, PERMISSIONS)
                // demonstrate how to set an audience for the publish
                // permissions,
                // if none are set, this defaults to FRIENDS
                .setDefaultAudience(SessionDefaultAudience.FRIENDS)
                .setRequestCode(AUTH_PUBLISH_ACTIONS_SCORES_ACTIVITY_CODE);
        session.requestNewPublishPermissions(newPermissionsRequest);
    }
}