public void onActivityResult(int requestCode, int resultCode, Intent data) {
    super.onActivityResult(requestCode, resultCode, data);
    if (requestCode == 1) {
         if(resultCode == RESULT_OK){

            String arg1 = data.getStringExtra("para1");
            String arg2 = data.getStringExtra("para2");
            String arg3 = data.getStringExtra("para3");
            String arg4 = data.getStringExtra("para4");
            // if you receive the data here,
            // you can add another element to List from which the -
            //`ListView` is populated and call `notifyDataSetChanged()` on the adapter.
            // like this `adapter.notifyDataSetChanged();` it will update the `listview` -
            //with new data that you received from the `NoteEditActivity.class` 

             adapter.notifyDataSetChanged(); // I am assuming you would add the changed item to the List
         }     
    }
}