public void findPages(Callback callback)
{
    accessToken = AccessToken.getCurrentAccessToken();
    foundPages = new ArrayList<>();

    GraphRequest request = GraphRequest.newGraphPathRequest(
            accessToken,
            "/me/accounts",
            new GraphRequest.Callback() {
                @Override
                public void onCompleted(GraphResponse response) {

                    try {

                        jsonObject = response.getJSONObject();
                        for(int i=0; i < jsonObject.getJSONArray("data").length(); i++)
                        {
                         page = response.getJSONObject().getJSONArray("data").getJSONObject(i).getString("name");
                            Log.d("viewmodel",page);
                            foundPages.add(page);

                        }
                        callback.apiResponseCallback(foundPages);

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            });

    request.executeAsync();
}