// create new Intent
Intent intent = new Intent();
intent.setAction(Intent.ACTION_SEND);

// set flag to give temporary permission to external app to use your FileProvider
intent.setFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);

// generate URI, I defined authority as the application ID in the Manifest, the last param is file I want to open
Uri uri = FileProvider.getUriForFile(this, BuildConfig.APPLICATION_ID, imageFile);
intent.putExtra(Intent.EXTRA_STREAM, uri);

// Set type to only show apps that can open your PNG file
intent.setType("image/png");

// start activity!
startActivity(Intent.createChooser(intent, "send"));