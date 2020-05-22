//Post
    public boolean setAlerts(String postData) {
        String path = String.format("api/wfm/v1/set-alerts/%s/%s", authToken, resourceId);
        return ConsumePostRequest(path, postData).first;
    }

    //Post
    public String isAlertUpdated(String lastDownloadDate) {
        String path = String.format("api/wfm/v1/is-alert-updated/%s/%s", authToken, lastDownloadDate);
        return ConsumeGetRequest(path);
    }