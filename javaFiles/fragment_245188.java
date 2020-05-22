mPhotoURLS.clear();
    for (int i = 0; i < numberOfPages; i++) {
        for (Photo photo : photoResults) {
            if (photo.getUrl_m() != null) {
                String photoURL = photo.getUrl_m();
                Log.v("PHOTO_URL:", photoURL);
                mPhotoURLS.add(photoURL);                    
            }
        }
    }
    mImageResultsAdapter.notifyDataSetChanged();