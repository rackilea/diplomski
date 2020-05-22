private void setupGridView(String selectedDirectory){
    Log.d(TAG, "setupGridView: directory chosen: " + selectedDirectory);
    final ArrayList<String> imgURLs = FileSearch.getFilePaths(selectedDirectory);

    ...

    if (imgURLs.isEmpty()) {
        // Array list is empty, handle accordingly
    } else {
       //set the first image to be displayed when the activity fragment view is inflated
       try{
            setImage(imgURLs.get(0), galleryImage, mAppend);
            mSelectedImage = imgURLs.get(0);
        } catch (IndexOutOfBoundsException e){
             Log.e(TAG, "setupGridView: ArrayIndexOutOfBoundsException: " +e.getMessage() );
        }
     }

     ...
 }