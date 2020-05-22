private void fireNfcVReadEvent(String type, NfcV nfcv, Parcelable[] messages) {

        JSONObject jsonObject = buildNfcVReadJSON(nfcv, messages);
        String tag = jsonObject.toString();

        String command = MessageFormat.format(javaScriptEventTemplate, type, tag);
        Log.v(TAG, command);
        this.webView.sendJavascript(command);

    }