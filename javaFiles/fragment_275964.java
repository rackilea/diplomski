TelephonyManager SignalManager = (TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE);

    PhoneStateListener signalListener = new PhoneStateListener() {

        public void onCallForwardingIndicatorChanged(boolean cfi) {
        }

        public void onCallStateChanged(int state, String incomingNumber) {
        }

        public void onCellLocationChanged(CellLocation location) {
        }

        public void onDataActivity(int direction) {
        }

        public void onDataConnectionStateChanged(int state) {
        }

        public void onDataConnectionStateChanged(int state, int networkType) {
        }

        public void onMessageWaitingIndicatorChanged(boolean mwi) {
        }

        public void onServiceStateChanged(ServiceState serviceState) {
        }

        public void onSignalStrengthsChanged(SignalStrength signalStrength) {
            super.onSignalStrengthsChanged(signalStrength);

            Log.e("onSignalStrengthsChanged: ", "GSM Cinr = "
                    + signalStrength.getGsmSignalStrength()); 
        }

    }; 

    SignalManager.listen(signalListener,
            PhoneStateListener.LISTEN_SIGNAL_STRENGTH);