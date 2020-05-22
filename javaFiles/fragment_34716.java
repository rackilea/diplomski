Resources resources = context.getResources();
String syncString = String.format(resources.getString(R.string.last_sync), fileLastSync);

TextView lastSyncTextView = ( (TextView) findViewById(R.id.last_sync) );

lastSyncTextView.setText(syncString);