public void onActivityResult(int requestCode, int resultCode, Intent intent) {

    if (requestCode == 0) {
        if (resultCode == RESULT_OK) {
            String contents = intent.getStringExtra("SCAN_RESULT");
            String format = intent.getStringExtra("SCAN_RESULT_FORMAT");
            String first_result = contents.substring( 0, contents.indexOf(","));

            scannedList.add(first_result);
            itemsAdapter.notifyDataSetChanged();
        }
     }
}