private static final int REQ_CODE_VERSION_UPDATE = 530;
private AppUpdateManager appUpdateManager;
private InstallStateUpdatedListener installStateUpdatedListener;

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

   checkForAppUpdate();
}

@Override
protected void onResume() {
    super.onResume();
    checkNewAppVersionState();
}

@Override
public void onActivityResult(int requestCode, final int resultCode, Intent intent) {
    super.onActivityResult(requestCode, resultCode, intent);

    switch (requestCode) {

        case REQ_CODE_VERSION_UPDATE:
            if (resultCode != RESULT_OK) { //RESULT_OK / RESULT_CANCELED / RESULT_IN_APP_UPDATE_FAILED
                L.d("Update flow failed! Result code: " + resultCode);
                // If the update is cancelled or fails,
                // you can request to start the update again.
                unregisterInstallStateUpdListener();
            }

            break;
    }
}

@Override
protected void onDestroy() {
    unregisterInstallStateUpdListener();
    super.onDestroy();
}


private void checkForAppUpdate() {
    // Creates instance of the manager.
    appUpdateManager = AppUpdateManagerFactory.create(AppCustom.getAppContext());

    // Returns an intent object that you use to check for an update.
    Task<AppUpdateInfo> appUpdateInfoTask = appUpdateManager.getAppUpdateInfo();

    // Create a listener to track request state updates.
    installStateUpdatedListener = new InstallStateUpdatedListener() {
        @Override
        public void onStateUpdate(InstallState installState) {
            // Show module progress, log state, or install the update.
            if (installState.installStatus() == InstallStatus.DOWNLOADED)
                // After the update is downloaded, show a notification
                // and request user confirmation to restart the app.
                popupSnackbarForCompleteUpdateAndUnregister();
        }
    };

    // Checks that the platform will allow the specified type of update.
    appUpdateInfoTask.addOnSuccessListener(appUpdateInfo -> {
        if (appUpdateInfo.updateAvailability() == UpdateAvailability.UPDATE_AVAILABLE) {
            // Request the update.
            if (appUpdateInfo.isUpdateTypeAllowed(AppUpdateType.FLEXIBLE)) {

                // Before starting an update, register a listener for updates.
                appUpdateManager.registerListener(installStateUpdatedListener);
                // Start an update.
                startAppUpdateFlexible(appUpdateInfo);
            } else if (appUpdateInfo.isUpdateTypeAllowed(AppUpdateType.IMMEDIATE) ) {
                // Start an update.
                startAppUpdateImmediate(appUpdateInfo);
            }
        }
    });
}

private void startAppUpdateImmediate(AppUpdateInfo appUpdateInfo) {
    try {
        appUpdateManager.startUpdateFlowForResult(
                appUpdateInfo,
                AppUpdateType.IMMEDIATE,
                // The current activity making the update request.
                this,
                // Include a request code to later monitor this update request.
                MainActivity.REQ_CODE_VERSION_UPDATE);
    } catch (IntentSender.SendIntentException e) {
        e.printStackTrace();
    }
}

private void startAppUpdateFlexible(AppUpdateInfo appUpdateInfo) {
    try {
        appUpdateManager.startUpdateFlowForResult(
                appUpdateInfo,
                AppUpdateType.FLEXIBLE,
                // The current activity making the update request.
                this,
                // Include a request code to later monitor this update request.
                MainActivity.REQ_CODE_VERSION_UPDATE);
    } catch (IntentSender.SendIntentException e) {
        e.printStackTrace();
        unregisterInstallStateUpdListener();
    }
}

/**
 * Displays the snackbar notification and call to action.
 * Needed only for Flexible app update
 */
private void popupSnackbarForCompleteUpdateAndUnregister() {
    Snackbar snackbar =
            Snackbar.make(drawerLayout, getString(R.string.update_downloaded), Snackbar.LENGTH_INDEFINITE);
    snackbar.setAction(R.string.restart, new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            appUpdateManager.completeUpdate();
        }
    });
    snackbar.setActionTextColor(getResources().getColor(R.color.action_color));
    snackbar.show();

    unregisterInstallStateUpdListener();
}

/**
 * Checks that the update is not stalled during 'onResume()'.
 * However, you should execute this check at all app entry points.
 */
private void checkNewAppVersionState() {
    appUpdateManager
            .getAppUpdateInfo()
            .addOnSuccessListener(
                    appUpdateInfo -> {
                        //FLEXIBLE:
                        // If the update is downloaded but not installed,
                        // notify the user to complete the update.
                        if (appUpdateInfo.installStatus() == InstallStatus.DOWNLOADED) {
                            popupSnackbarForCompleteUpdateAndUnregister();
                        }

                        //IMMEDIATE:
                        if (appUpdateInfo.updateAvailability()
                                == UpdateAvailability.DEVELOPER_TRIGGERED_UPDATE_IN_PROGRESS) {
                            // If an in-app update is already running, resume the update.
                            startAppUpdateImmediate(appUpdateInfo);
                        }
                    });

}

/**
 * Needed only for FLEXIBLE update
 */
private void unregisterInstallStateUpdListener() {
    if (appUpdateManager != null && installStateUpdatedListener != null)
        appUpdateManager.unregisterListener(installStateUpdatedListener);
}