Intent photoPickerIntent = new Intent(
                        Intent.ACTION_PICK,
                        android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                photoPickerIntent.setType("image/*");

                photoPickerIntent.putExtra("scaleType", "centerCrop");
                photoPickerIntent.putExtra("crop", "true");
                photoPickerIntent.putExtra("aspectX", 1);
                photoPickerIntent.putExtra("aspectY", 1);

                //....snip....
                photoPickerIntent.putExtra("outputX", 400);
                photoPickerIntent.putExtra("outputY", 400);
                //....snip....

                photoPickerIntent.putExtra(MediaStore.EXTRA_OUTPUT, getBackgroundUri());
                photoPickerIntent.putExtra("outputFormat",Bitmap.CompressFormat.JPEG.toString());
                startActivityForResult(photoPickerIntent, ActivityCrop);