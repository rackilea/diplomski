void retrieveImages()
{
        //some method in sherlock activity 
        mImageUriList = new ArrayList<String>();
        mImageUriList = Utils.fetchImages(this);
        new GetImageAsyncTask(this, mImageUriList).execute();
        //NOT passing progress dialog to async task,just activity context
}