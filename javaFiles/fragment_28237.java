ArrayList<String> selectedItems = imageAdapter.getCheckedItems();

    if (selectedItems!= null && selectedItems.size() > 0) {
        //Toast.makeText(MultiPhotoSelectActivity.this, "Total photos selected: " + selectedItems.size(), Toast.LENGTH_SHORT).show();
        Log.d(MultiPhotoSelectActivity.class.getSimpleName(), "Selected Items: " + selectedItems.toString());
        final Intent data = new Intent();
        data.putStringArrayListExtra("selectedItems", selectedItems);
        setResult(Activity.RESULT_OK, data);
        finish();
    }
}