/**
     * see {@link android.net.wifi.WifiManager#setWifiEnabled(boolean)}
     * @param enable {@code true} to enable, {@code false} to disable.
     * @return {@code true} if the enable/disable operation was
     *         started or is already in the queue.
     */
    public synchronized boolean setWifiEnabled(boolean enable) {
        enforceChangePermission();
        Slog.d(TAG, "setWifiEnabled: " + enable + " pid=" + Binder.getCallingPid()
                    + ", uid=" + Binder.getCallingUid());
        if (DBG) {
            Slog.e(TAG, "Invoking mWifiStateMachine.setWifiEnabled\n");
        }
        if (enable) {
            reportStartWorkSource();
        }
        mWifiStateMachine.setWifiEnabled(enable);
        /*
         * Caller might not have WRITE_SECURE_SETTINGS,
         * only CHANGE_WIFI_STATE is enforced
         */
        long ident = Binder.clearCallingIdentity();
        try {
            handleWifiToggled(enable);
        } finally {
            Binder.restoreCallingIdentity(ident);
        }
        if (enable) {
            if (!mIsReceiverRegistered) {
                registerForBroadcasts();
                mIsReceiverRegistered = true;
            }
        } else if (mIsReceiverRegistered) {
            mContext.unregisterReceiver(mReceiver);
            mIsReceiverRegistered = false;
        }
        return true;
    }