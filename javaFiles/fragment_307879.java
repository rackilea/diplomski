/*
     * Sends a json object to the client as parameter to a method which is defined in gECB.
     */
    public static void sendJavascript(JSONObject _json) {
            String _d = "javascript:" + gECB + "(" + _json.toString() + ")";
            Log.v(TAG, "sendJavascript: " + _d);

            if (gECB != null && gWebView != null) {
                    gWebView.sendJavascript(_d); 
            }
    }