@Override
        protected String doInBackground(String... params) {

            res = null;
            PutUtility put = new PutUtility();

            put.setParam("ueid", params[0]);
            put.setParam("firm_no", params[1]);
            put.setParam("date_incorporation", params[2]);
            put.setParam("business_name", params[3]);
            put.setParam("block_no", params[4]);

            try {

                    res = put.postData(
                            "Api URL here");

                Log.v("res", res);
            } catch (Exception objEx) {
                objEx.printStackTrace();
            }

            return res;
        }


@Override
        protected void onPostExecute(String res) {

            try {

            } catch (Exception objEx) {
                mProgressDialog.dismiss();
                objEx.printStackTrace();
            }
        }