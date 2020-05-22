GetImageAsyncTask(Context mContext,ArrayList<String> mImageUriList)
{
    // Other intializations
    mProgressDialog = new ProgressDialog(mContext);

    mProgressDialog = new ProgressDialog(this);
    // progress dialog here is asynctask class member
    mProgressDialog.setIndeterminate(false);
    mProgressDialog.setMessage("Processing Images..");
    mProgressDialog.setMax(100);
    mProgressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
    mProgressDialog.setCanceledOnTouchOutside(false);
}