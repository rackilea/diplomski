@Override
    protected void onStop() {
        // TODO Auto-generated method stub
        super.onStop();
            if(progressDialog.isShowing())
        {
        progressDialog.dismiss();
        }
         }