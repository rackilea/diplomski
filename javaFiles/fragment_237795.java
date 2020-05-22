// get our list
ListView listView = rootView.findViewById(R.id.list);

// set the click listener on the whole list
listView.setOnItemClickListener(new OnItemClickListener() {
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        if (view.isClickable()){
            Toast.makeText(getActivity(), "Cliquei row # " + position, Toast.LENGTH_LONG).show();
        }
    }
});