protected void onNewIntent( Intent intent) {
    if (intent.hasExtra(NfcAdapter.EXTRA_TAG)) {
        Toast.makeText(getContext(), "NFC tag discovered!", Toast.LENGTH_SHORT).show();
        tag = intent.getParcelableExtra(NfcAdapter.EXTRA_TAG);
        writebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NdefMessage ndefMessage = createNdefMessage(txtName.getText().toString(), txtCountry.getText().toString(),txtID.getText().toString());
                writeNdefMessage(tag, ndefMessage);
            }
        });
    }