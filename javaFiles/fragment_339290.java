// Tab for Photos
    TabSpec photospec = tabHost.newTabSpec("Photos");
    // setting Title and Icon for the Tab
    photospec.setIndicator("Photos", getResources().getDrawable(R.drawable.icon_photos_tab));
    Intent photosIntent = new Intent(this, PhotosActivity.class);
    photospec.setContent(photosIntent);