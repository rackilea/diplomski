public void findPages(Callback callback) {
    //
    // 
    ........
     for(int i=0; i < jsonObject.getJSONArray("data").length(); i++)
                    {
                     page = response.getJSONObject().getJSONArray("data").getJSONObject(i).getString("name");
                        Log.d("viewmodel",page);
                        foundPages.add(page);

                    } 
    callback.apiResponseCallback(foundPages);//here we are returning the data when it is done
}