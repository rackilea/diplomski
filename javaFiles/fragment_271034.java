next_upload.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent intent = new Intent(UploadActivity2.this, UploadActivity3.class);
        intent.putStringArrayListExtra("SELECTED_IMAGES", selectedImages);
        startActivity(intent);
    }
});