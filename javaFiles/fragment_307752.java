@Override
    public boolean execute(String action, JSONArray data, CallbackContext callbackContext) throws JSONException {

        Log.d(TAG, "execute " + action);

        if (!getNfcStatus().equals(STATUS_NFC_OK)) {
            callbackContext.error(getNfcStatus());
            return true; // short circuit
        }

        createPendingIntent();


         if (action.equalsIgnoreCase(REGISTER_NFCV)) {
          registerNfcV(callbackContext);

        }else {
            // invalid action
            return false;
        }

        return true;
    }