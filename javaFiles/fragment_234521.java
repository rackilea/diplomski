private void makeIconVisible(ImageView icon)
{
    new MakeIconVisibleTask().execute(icon);
}

class MakeIconVisibleTask extends AsyncTask<View, Void, Integer> {
    private View mView;
    String mResult = null;

    @Override
    protected Integer doInBackground(View... arg0) {
        mView = arg0[0];

        mResult = Utils.httpPost("MyURLHere", SomePostData);

        int success = -1; 
        if(mResult!=null && !mResult.isEmpty()) {
            success = 1;
        }

        return success;
    }

    @Override
    protected void onPostExecute(Integer res) {
        if(res >0 ) {
            mView.setVisibility(View.VISIBLE);
        }
    }

}