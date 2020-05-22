@Override
protected String doInBackground(Void... params) 
{
    String twitterTimeline = getTwitterTimeline();
    return twitterTimeline;
}

@Override
protected void onPostExecute(String twitterTimeline) 
{
    try 
    {
        String tweets = "";
        JSONArray jsonArray = new JSONArray(twitterTimeline);
        for (int i = 0; i < jsonArray.length(); i++) 
        {
            JSONObject jsonObject = jsonArray.getJSONObject(i);
            int j = i + 1;
            tweets += "Tweet #" + j + " \n";
            tweets += "Date:" + jsonObject.getString("created_at") + "\n";
            tweets += "Post:" + jsonObject.getString("text") + "\n\n";
        }
        tweetTextView = (TextView) rootView.findViewById(R.id.tweetTextView);
        tweetTextView.setText(tweets);
    }   
    catch (JSONException e) 
    {
        e.printStackTrace();
    }   
    catch (Exception e) 
    {
        e.printStackTrace();
    }
    super.onPostExecute(result);
}