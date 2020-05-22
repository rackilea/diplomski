next_upload.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent intent = new Intent(UploadActivity2.this, UploadActivity3.class);
        intent.putExtra("SELECTED_IMAGE", selectedImage);
        startActivity(intent);
    }
});