Facebook facebook = new Facebook("XXXXXasdasdajksdad");

TextView nText;

@Override
public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.main);

    nText = (TextView) this.findViewById(R.id.nameText);

    facebook.authorize(this, new String[] {"offline_access", "user_interests", "friends_interests"},

            new DialogListener() {
        public void onComplete(Bundle values) {
            getFriends();
            setContentView(R.layout.homepage);
        }

        public void onFacebookError(FacebookError error) {}

        public void onError(DialogError e) {}

        public void onCancel() {}
    });


}

private void getFriends(){

    JSONObject json_data = null;

    try
    {
        JSONObject response = Util.parseJson(facebook.request("me/friends")); // Get a friend information from facebook
        JSONArray jArray = response.getJSONArray("data");

        json_data = jArray.getJSONObject(0);
        String name = json_data.getString("name");
        Log.i("friend is", name);
        nText.setText(name);

    }
    catch (MalformedURLException e)
    {
        e.printStackTrace();
    }
    catch (JSONException e)
    {
        e.printStackTrace();
    }
    catch (IOException e)
    {
        e.printStackTrace();
    }
    catch (FacebookError e)
    {
        e.printStackTrace();
    }

}

@Override
public void onActivityResult(int requestCode, int resultCode, Intent data) {
    super.onActivityResult(requestCode, resultCode, data);

    facebook.authorizeCallback(requestCode, resultCode, data);
}