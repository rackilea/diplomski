public void showList(final JSONArray responsearray) {
 try {

    //here  
    myList = new ArrayList<>();

    for (int i = 0; i < responsearray.length(); i++) {
        JSONObject responseObject = responsearray.getJSONObject(i);
        Log.e("COUNT" + i, String.valueOf(responseObject));
        imageOne = responseObject.getString(TAG_PHOTO_ONE);                
        get = new HashMap<>();
        get.put(TAG_PHOTO_ONE, imageOne);

        myList.add(String.valueOf(get));
    }

        viewpager_adapter = new ViewPager_Adapter(getActivity(), myList);
        String test = String.valueOf(myList);
        String imgpath = getString(R.string.imgpath);
        String finalimgpath = imgpath + imageOne;
        Log.e("FINALPATH", finalimgpath);

} catch (JSONException e) {
    e.printStackTrace();
}
mPager.setAdapter(viewpager_adapter);
viewpager_adapter.notifyDataSetChanged();
}