private boolean isCheckNetworkThreadActive = false; // Flag to indicate if thread is active
private boolean isNetworkAvaiableUIActive = false; // Flag to indicate which view is showing
final private static int NETWORK_CHECK_INTERVAL = 5000; // Sleep interval between checking network

@Override
protected void onResume() {
    // Start network checking when activity resumes
    startCheckNetwork();
    super.onResume();
}

@Override
protected void onPause() {
    // Stop network checking when activity pauses
    stopCheckNetwork()
    super.onPause();
}

private void setNetworkAvaiableUI() {
    // If network avaible UI is not showing, we will change UI
    if (!isNetworkAvaiableUIActive) {
        isNetworkAvaiableUIActive = true;
        runOnUiThread(new Runnable() {
            public void run() {
                // Update UI here when network is available.
            }
        });
    }
}
private void setNetworkNotAvaiableUI() {
    // If network avaible UI is showing, we will change UI
    if (isNetworkAvaiableUIActive) {
        isNetworkAvaiableUIActive = false;
        runOnUiThread(new Runnable() {
            public void run() {
                // Update UI here when network is unavailable.
            }
        });
    }
}

private void startCheckNetwork() {
    // Only one network checking thread can be run at the time.
    if (!isCheckNetworkThreadActive) {
        isCheckNetworkThreadActive = true;

        Thread checkNetworkThread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (isCheckNetworkThreadActive) {
                    if (isNetworkAvailable()) {
                        // Set UI if notwork is available
                        setNetworkAvaiableUI();
                    } else {
                        // Set UI if notwork is not available
                        setNetworkNotAvaiableUI();
                    }

                    // Sleep after finish checking network
                    try {
                        Thread.sleep(NETWORK_CHECK_INTERVAL);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        checkNetworkThread.setName("Check Network Thread");
        checkNetworkThread.start();
    }
}

private void stopCheckNetwork() {
    // This will break while loop of network checking thread.
    isCheckNetworkThreadActive = false;
}