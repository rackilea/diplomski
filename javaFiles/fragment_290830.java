public class aThread extends AsyncTask<Void, Void, Void> {
        @Override
        protected Void doInBackground(Void... args) {
            try {
                //Do your downloading and stuff
                                asyncHandler.sendMessage(asyncHandler.obtainMessage(0));
            } catch (Exception e) {
                Log.e("1", "Error", e);
            }
            return null;
        }
    }

Handler asyncHandler = new Handler() {
        public void handleMessage(Message msg) {
            pd.dismiss();
            if (msg.what == 0) {
                //update what you need to               
            }           
        }
    };