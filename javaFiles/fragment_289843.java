enter/** Classes **/
private class GetProfilePicAsyncTask extends AsyncTask<Void, Void, Bitmap> {

    @Override
    protected Bitmap doInBackground(Void... params) {
        return Utility.getBitmap(User.getInstance().getAvatar());
    }

    @Override
    protected void onPostExecute(Bitmap result) {
        if (result != null) {
            avatar.setImageBitmap(result);
        }
        else {
            ...
        }
    }

}