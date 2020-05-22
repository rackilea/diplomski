void onAuthorized() {
        if(getIntent().getBooleanExtra("photos_flow", false)) {
            // most possibly you should pass some id into SpecificPhotoActivity's intent
            Intent[] intents = new Intent[]{new Intent(this, PhotosActivity.class), new Intent(this, SpecificPhotoActivity.class)};
            startActivities(intents);
            finish();
        }
    }