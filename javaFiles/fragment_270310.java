list.setOnItemClickListener(new OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> arg0, View view, int position,
                    long id) {
                Log.e("item clicks", "selected: " + position);
                String contactNum = ((TextView)view.findViewById(R.id.listPhone)).getText().toString();
                phoneCall(contactNum);
            }
});