void parseMessage() {
        cordova.getThreadPool().execute(new Runnable() {
            @Override
            public void run() {
                Log.d(TAG, "parseMessage " + getIntent());
                Intent intent = getIntent();
                String action = intent.getAction();


                Log.d(TAG, "action " + action);
                if (action == null) {
                    return;
                }


                if (action.equals(NfcAdapter.ACTION_TECH_DISCOVERED) || action.equals(NfcAdapter.ACTION_TAG_DISCOVERED)){
                     NfcvData ma;

                     Tag tagFromIntent  = (Tag)intent.getParcelableExtra(NfcAdapter.EXTRA_TAG);
                     Parcelable[] messages = intent.getParcelableArrayExtra((NfcAdapter.EXTRA_NDEF_MESSAGES));
                     NfcV mfc = NfcV.get(tagFromIntent);
                     Tag tag = mfc.getTag();
                     fireNfcVReadEvent(NFCV, mfc, messages);

                }

                setIntent(new Intent());
            }
        });
    }