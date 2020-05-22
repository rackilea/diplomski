private OnClickListener mListener = new OnClickListener() {

    public void onClick(View v) {
        ArrayList<YourObject> al = getSomeData(int startRow, int endRow);
                    MyCustomAdapter adapter = new MyCustomAdapter();
                    for(YourObject a : al)
                       adapter.add(a);
                       getListView.setAdapter(adapter);
                       notifyDataSetChanged();
    }
};