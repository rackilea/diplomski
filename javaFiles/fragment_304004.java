IntentFilter ndef = new IntentFilter(NfcAdapter.ACTION_NDEF_DISCOVERED);
try {
    ndef.addDataType("*/*");    /* Handles all MIME based dispatches. 
                                   You should specify only the ones that you need. */
}
catch (MalformedMimeTypeException e) {
    throw new RuntimeException("fail", e);
}

mFilters = new IntentFilter[] {
        ndef,
};

mTechLists = new String[][] { new String[] { NfcF.class.getName() } };
NfcAdapter.enableForegroundDispatch(this, mPendingIntent, mFilters,
                mTechLists);