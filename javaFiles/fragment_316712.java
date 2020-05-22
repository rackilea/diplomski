class GetProductDetails extends AsyncTask<String, String, JSONObject> {

        /**
         * Before starting background thread Show Progress Dialog
         * */

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            tDialog = new ProgressDialog(My_Task.this);
            tDialog.setMessage("Loading task details. Please wait...");
            tDialog.setIndeterminate(false);
            tDialog.setCancelable(true);
            tDialog.show();
        }
   protected JSONObject doInBackground(String... params) {

                   JSONObject my_task 
                    // Check for success tag
                    int success;
                    try {
                        // Building Parameters
                        List<NameValuePair> params = new ArrayList<NameValuePair>();
                        params.add(new BasicNameValuePair("cid", cid));

                        // getting product details by making HTTP request
                        // Note that product details url will use GET request
                        JSONObject json = JSONParser.makeHttpRequest(
                                url_read_mytask, "GET", params);

                        // check your log for json response
                        Log.d("Single Task Details", json.toString());

                        // json success tag
                        success = json.getInt(TAG_SUCCESS);
                        if (success == 1) {
                            // successfully received product details
                            JSONArray my_taskObj = json
                                    .getJSONArray(TAG_MYTASK); // JSON Array

                            // get first product object from JSON Array
                            my_task = my_taskObj.getJSONObject(0);


                        }
                        else
                        {
                            // task with cid not found
                        }
                    } 
                    catch (JSONException e) {
                        e.printStackTrace();
                    }


            return my_task;
        }
        protected void onPostExecute(JSONObject my_task) {
            // dismiss the dialog once got all details

            // task with this cid found
            // Edit Text
             // display task data in EditText

             cus_name_txtbx = (EditText) findViewById(R.id.cus_name_txt);
             cus_name_txtbx.setText(my_task.getString(TAG_NAME));

             contact_no_txtbx = (EditText) findViewById(R.id.contact_no_txt);
             contact_no_txtbx.setText(my_task.getString(TAG_CONTACT));

             ticket_no_txtbx = (EditText) findViewById(R.id.ticket_no_txt);
             ticket_no_txtbx.setText(my_task.getString(TAG_TICKET));

             task_detail_txtbx = (EditText) findViewById(R.id.task_detail_txt);
             task_detail_txtbx.setText(my_task.getString(TAG_TASKDETAIL));
            tDialog.dismiss();
        }