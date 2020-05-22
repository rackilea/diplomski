private final MyListener mListener = new MyListener()
   {

    @Override
    public void onComplete(JSONArray result) {

        blogData = result;
        articleList();

        ArrayAdapter<String> arrayAdapter1 = new ArrayAdapter<String>(getActivity(),   R.layout.layout_listitem, R.id.titleTV, blogPostTitle);
            listview1.setAdapter(arrayAdapter1);
    }
};