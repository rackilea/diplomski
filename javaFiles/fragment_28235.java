MultiPhotoSelectActivity.java

Intent intent = new Intent(MultiPhotoSelectActivity.this,PreuploadActivity.class);
    intent.putStringArrayListExtra("selectedItems", selectedItems);
    setResult(RESULT_OK, intent);
    startActivity(intent);