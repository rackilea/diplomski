public void showList(final JSONArray responsearray) {
try {
    for (int i = 0; i < responsearray.length(); i++) {
        JSONObject responseObject = responsearray.getJSONObject(i);
        Log.e("COUNT" + i, String.valueOf(responseObject));
        imageOne = responseObject.getString(TAG_PHOTO_ONE);
        get = new HashMap<>();
        get.put(TAG_PHOTO_ONE, imageOne);
        myList.add(get);
    }
    adapter = new SimpleAdapter(getActivity(), myList, R.layout.row_more_images,
            new String[]{TAG_PHOTO_ONE},
            new int[]{R.id.photo1}) {
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            final View v = super.getView(position, convertView, parent);
            if (convertView == null) {
                TextView photo1 = v.findViewById(R.id.photo1);
                photoOne = v.findViewById(R.id.photo_one);
                String imgPath = getString(R.string.moreimgpath);
                if (!photo1.getText().toString().equalsIgnoreCase("null")) {
                    final_image_url = imgPath + photo1.getText().toString();
                    Log.e("FINALPATH", final_image_url);
                    ImageLoader.getInstance().displayImage(final_image_url, photoOne, options, animateFirstListener);
                }
                    adapter.notifyDataSetChanged();
                    gridview.invalidateViews();
            }
            return v;
        }
    };
    if (gridview.getAdapter() == null) {
        gridview.setAdapter(adapter);
    }
    gridview.setOnItemClickListener(this);
} catch (JSONException e) {
    e.printStackTrace();
} catch (NullPointerException e) {
    e.printStackTrace();
}}