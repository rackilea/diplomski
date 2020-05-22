ViewModel.saveoBJECT(mObject, new Callback() {
        @Override
        public void result(Result result) {
            switch (result){
                case SUCCESS:
                    mProgressbar.setVisibility(View.GONE);
                    break;
                case FAILED:
                    Log.v(TAG, "Failed");
                    Toast.makeText(getApplicationContext(), "OOPS ERROR!", Toast.LENGTH_LONG).show();
                    break;
            }
        }

        @Override
        public void url(Uri downloadUrl) { }
    });