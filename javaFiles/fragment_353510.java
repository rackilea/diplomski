ImagePicker imagePicker = new ImagePicker(Activity.this);
imagePicker.setImagePickerCallback(new ImagePickerCallback(){
        @Override
        public void onImagesChosen(List<ChosenImage> images) {
            // Display images
        }

        @Override
        public void onError(String message) {
            // Do error handling
        }
    }
);
// imagePicker.allowMultiple(); // Default is false
// imagePicker.shouldGenerateMetadata(false); // Default is true
// imagePicker.shouldGenerateThumbnails(false); // Default is true
imagePicker.pickImage();