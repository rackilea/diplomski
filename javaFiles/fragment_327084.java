override fun onNewIntent(intent: Intent) {
    super.onNewIntent(intent)
    ...
    if (NfcAdapter.ACTION_NDEF_DISCOVERED == intent.action) {
        intent.getParcelableArrayExtra(NfcAdapter.EXTRA_NDEF_MESSAGES)?.also { rawMessages ->
            val messages: List<NdefMessage> = rawMessages.map { it as NdefMessage }
            // Process the messages array.
            ...
        }
    }
}