private class MyAsyncTask extends AsyncTask<String, String, String>
        {

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
            }
            @Override
            protected String doInBackground(String... params) {
                String data="["15.493511","73.818659"]"; // Assuming that it is your static data
                try {
                JSONArray myArray=new JSONArray(data);

                         String lattitude=myArray.getString(0);
                         String longitudetude=myArray.getString(1);

                          }
                } catch (JSONException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

                return null;
            }

            @Override
            protected void onPostExecute(String result) {
                super.onPostExecute(result);
                //update your UI or do your task;
                }

            }

        }