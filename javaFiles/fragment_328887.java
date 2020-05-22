private class GetData extends AsyncTask<String, Void, JSONObject> {
    @Override
    protected void onPreExecute() {
        super.onPreExecute();

        progressDialog = ProgressDialog.show(Calendar.this, "", "");
    }

    @Override
    protected JSONObject doInBackground(String... params) {
        String response;

        try {
            HttpClient httpclient = new DefaultHttpClient();
            HttpPost httppost = new HttpPost(params[0]);
            HttpResponse responce = httpclient.execute(httppost);
            HttpEntity httpEntity = responce.getEntity();

            response = EntityUtils.toString(httpEntity);
            Log.d("response is", response);

            return new JSONObject(response);

        } catch (Exception ex) {

            ex.printStackTrace();

        }

        return null;
    }

    @Override
    protected void onPostExecute(JSONObject result) 
    {
        super.onPostExecute(result);

        progressDialog.dismiss();

        if(result != null)
        {
            try
            {
                JSONObject jobj = result.getJSONObject("result");

                String status = jobj.getString("status");

                if(status.equals("true"))
                {
                    JSONArray array = jobj.getJSONArray("data");

                    for(int x = 0; x < array.length(); x++)
                    {
                        HashMap<String, String> map = new HashMap<String, String>();

                        map.put("name", array.getJSONObject(x).getString("name"));

                        map.put("date", array.getJSONObject(x).getString("date"));

                        map.put("description", array.getJSONObject(x).getString("description"));

                        list.add(map);
                    }

                    CalendarAdapter adapter = new CalendarAdapter(Calendar.this, list);

                    list_of_calendar.setAdapter(adapter);
                }
            }
            catch (Exception e) 
            {
                e.printStackTrace();
            }
        }
        else
        {
            Toast.makeText(Calendar.this, "Network Problem", Toast.LENGTH_LONG).show();
        }
    }
}