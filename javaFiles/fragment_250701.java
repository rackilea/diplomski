String query = "scans/" + scanId + "/launch";
    String launchJson = "{\"scan_id\":\"" +String.valueOf(scanId) + "\", \"alt_targets\":[\"" + ip +"\"]}";

    /* launch it! */
    Response respLaunch = null;
    try {
        respLaunch = postRequest(query, launchJson);
    } catch (Exception e) {
        e.printStackTrace();
    }