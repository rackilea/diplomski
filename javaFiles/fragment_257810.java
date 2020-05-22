do {
        logDebug("Calling getPurchases with continuation token: " + continueToken);
        if (mService == null || mContext == null) {
            logError("Our service and/or our context are null.  Exiting.");
            return IABHELPER_UNKNOWN_ERROR;
        }
        Bundle ownedItems = mService.getPurchases(3, mContext.getPackageName(), itemType, continueToken);
        // ...
    }