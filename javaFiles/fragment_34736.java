int RESPONSE_CODE = 123; // from this code will will differentiate if 
                         // the activity which we started actually did the task or not

    listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            Intent intent = new Intent(getApplicationContext(), NoteEditActivity.class);
            intent.putString("para1","arg1");
            intent.putString("para2","arg2");
            intent.putString("para3","arg3");
            intent.putString("para4","arg4");
            startActivityForResult(intent, RESPONSE_CODE);
        }
    });