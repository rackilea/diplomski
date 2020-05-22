private OnItemClickListener listPairedClickItem = new OnItemClickListener() {
    @Override
    public void onItemClick(AdapterView < ? > arg0, View arg1, int arg2, long arg3) {
        String personName = usernames.get(position);
        Toast.makeText( context, "listview clicked ", Toast.LENGTH_LONG ).show();
        Intent intent = new Intent(currenactivityname.this, activitytolaunchname.class);
        intent.putExtra("username",personName ); //get this name in next activity and show in title  bar
        startActivity(intent);
    }
};