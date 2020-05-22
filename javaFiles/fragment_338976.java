interface InternetCheck {
    void isAvailable();
    void isNotAvailable();
}

public Boolean isOnline(InternetCheck internetCheck) {
    try {
        p1 = java.lang.Runtime.getRuntime().exec("ping -c 1 www.google.com");
        int returnVal = p1.waitFor();
        boolean reachable = (returnVal == 0);
        if (reachable) {
            new uploadDB(new uploadDB.returnResult() {
                @Override
                public void onFinish(String result) {
                    if (result.equalsIgnoreCase("success")) {
                        isInternetConnected = true;
                        internetCheck.isAvailable();
                    } else {
                        isInternetConnected = false;
                        internetCheck.isNotAvailable();
                        showdialog("No Internet Connection", "Connection to server failed.");
                    }
                }
            }).execute("ping");
        } else {
            isInternetConnected = false;
            internetCheck.isNotAvailable();
            showdialog("No Internet", "Internet connection is needed to perform certain actions.");
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
    return false;
}


public void yourButtonClickEvent() {
    isOnline(new InternetCheck() {
        @Override
        public void isAvailable() {
          // Now Internet is available
        }

        @Override
        public void isNotAvailable() {

        }
    });
}